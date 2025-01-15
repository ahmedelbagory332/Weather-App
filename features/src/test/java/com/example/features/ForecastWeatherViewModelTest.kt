package com.example.features
import com.example.core.Resource
import com.example.features.forecast_weather_screen.domain.use_case.GetForecastWeatherUseCase
import com.example.features.forecast_weather_screen.presentaion.ForecastWeatherIntent
import com.example.features.forecast_weather_screen.presentaion.ForecastWeatherViewModel
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import com.example.features.weather_screen.domain.use_case.GetCityNameUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ForecastWeatherViewModelTest {

    private lateinit var viewModel: ForecastWeatherViewModel

    @MockK(relaxed = true)
    private lateinit var getForecastWeatherUseCase: GetForecastWeatherUseCase

    @MockK(relaxed = true)
    private lateinit var getCityNameUseCase: GetCityNameUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher()) // Set a test dispatcher
        viewModel = ForecastWeatherViewModel(getForecastWeatherUseCase, getCityNameUseCase)
    }

    @After
    fun tearDown() {
        unmockkAll()
        Dispatchers.resetMain() // Reset the dispatcher
    }

    @Test
    fun `getForecastWeather should emit loading, success, and update state correctly`() = runTest {
        // Arrange: Mock the use cases
        coEvery { getCityNameUseCase() } returns "Cairo"
        coEvery { getForecastWeatherUseCase("Cairo") } returns flow {
            emit(Resource.Loading<List<CurrentWeatherModel>>()) // Emitting loading state
            emit(Resource.Success(listOf(CurrentWeatherModel(temp = 25f)))) // Emitting success state
        }

        // Act: Trigger the action to get the forecast
        viewModel.sendIntent(ForecastWeatherIntent.GetForecastWeather)
        // Wait until all flows are completed
        advanceUntilIdle()

        // Assert: Check if the state has been updated with weather data after success
        assertEquals(viewModel.forecastWeatherState.value.weatherList.size, 1)
        assertEquals(viewModel.forecastWeatherState.value.weatherList[0].temp, 25f)

        // Assert: Check if the error state is not emitted
        assertTrue(viewModel.forecastWeatherState.value.error.isEmpty())

        // Assert: Check that the loading state is set to false after success
        assertFalse(viewModel.forecastWeatherState.value.isLoading)
    }


    @Test
    fun `getForecastWeather should emit error if city is empty`() = runTest {
        // Arrange: Mock the use cases
        coEvery { getCityNameUseCase() } returns "invalid city name" // Empty city name
        coEvery { getForecastWeatherUseCase(any()) } returns flow {
            emit(Resource.Error("Data not found"))
        }

        // Act: Trigger the action to get the forecast
        viewModel.sendIntent(ForecastWeatherIntent.GetForecastWeather)

        // Wait until all flows are completed
        advanceUntilIdle()

        // Assert: Check if the error state is emitted with the correct message
        assertEquals(viewModel.forecastWeatherState.value.error.trim(), "Data not found")
    }
}
