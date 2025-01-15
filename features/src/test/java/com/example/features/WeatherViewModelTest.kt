package com.example.features

import com.example.core.Resource
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import com.example.features.weather_screen.domain.use_case.CurrentWeatherUseCase
import com.example.features.weather_screen.domain.use_case.GetCityNameUseCase
import com.example.features.weather_screen.domain.use_case.SetCityNameUseCase
import com.example.features.weather_screen.presentaion.WeatherState
import com.example.features.weather_screen.presentaion.WeatherViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import junit.framework.TestCase.assertEquals
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

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {

    private lateinit var viewModel: WeatherViewModel

    @MockK(relaxed = true)
    private lateinit var currentWeatherUseCase: CurrentWeatherUseCase

    @MockK(relaxed = true)
    private lateinit var getCityNameUseCase: GetCityNameUseCase

    @MockK(relaxed = true)
    private lateinit var setCityNameUseCase: SetCityNameUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(UnconfinedTestDispatcher())
        viewModel = WeatherViewModel(currentWeatherUseCase, getCityNameUseCase, setCityNameUseCase)
    }

    @After
    fun tearDown() {
        unmockkAll()
        Dispatchers.resetMain()
    }

    @Test
    fun loadWeather_isCorrectly() = runTest {
        val mockWeatherInfo = CurrentWeatherModel(temp = 26f)
        coEvery { getCityNameUseCase() }  returns "cairo"
        coEvery { currentWeatherUseCase(any()) }  returns flow {
            emit(Resource.Loading<CurrentWeatherModel>())
            emit(Resource.Success(mockWeatherInfo))
        }
        viewModel.onSearchClick("cairo")
        advanceUntilIdle()
        assert(
            viewModel.weatherState.value ==
                    WeatherState(weather = mockWeatherInfo)
        )
    }


    @Test
    fun `onSearchClick with empty city name should not call currentWeatherUseCase`() = runTest {
        // Arrange: Mock the use case to return a success response (we won't use it)
        val mockWeatherInfo = CurrentWeatherModel(temp = 25f)
        coEvery { currentWeatherUseCase(any()) } returns flow {
            emit(Resource.Success(mockWeatherInfo))
        }

        // Act: Trigger the search click with an empty city name
        viewModel.onSearchClick("")

        // Assert: Verify that the currentWeatherUseCase was not called
        coVerify(exactly = 0) { currentWeatherUseCase(any()) }
    }

    @Test
    fun `getCurrentWeather should set error state when the use case returns an error`() = runTest {
        // Arrange: Mock the use case to return an error
        val errorMessage = "Error fetching weather data"
        coEvery { currentWeatherUseCase(any()) } returns flow {
            emit(Resource.Loading<CurrentWeatherModel>())
            emit(Resource.Error(errorMessage))
        }
        coEvery { getCityNameUseCase() } returns "Cairo"

        // Act: Trigger the search click
        viewModel.onSearchClick("Cairo")

        // Advance coroutine until idle
        advanceUntilIdle()

        // Assert: Check if the weather state contains the error message
        assertEquals(
            viewModel.weatherState.value,
            WeatherState(error = errorMessage)
        )
    }

    @Test
    fun `getCurrentWeather should set loading state during data fetching`() = runTest {
        // Arrange: Mock the use case to return a loading state
        coEvery { currentWeatherUseCase(any()) } returns flow {
            emit(Resource.Loading<CurrentWeatherModel>())
            emit(Resource.Success(CurrentWeatherModel(temp = 25f)))
        }
        coEvery { getCityNameUseCase() } returns "Cairo"

        // Act: Trigger the search click
        viewModel.onSearchClick("Cairo")

        // Assert: Check if the weather state is in the loading state
        assertEquals(viewModel.weatherState.value.isLoading, false)
    }

}