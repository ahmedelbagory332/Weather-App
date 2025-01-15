package com.example.features.forecast_weather_screen.presentaion


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Resource
import com.example.features.forecast_weather_screen.domain.use_case.GetForecastWeatherUseCase
import com.example.features.weather_screen.domain.use_case.GetCityNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ForecastWeatherViewModel @Inject constructor(
    val getForecastWeatherUseCase: GetForecastWeatherUseCase,
    val getCityNameUseCase: GetCityNameUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(ForecastWeatherState())
    val forecastWeatherState: StateFlow<ForecastWeatherState>
        get() = _state

    fun sendIntent(intent: ForecastWeatherIntent) {
            when (intent) {
                is ForecastWeatherIntent.GetForecastWeather -> getForecastWeather()
            }
    }

    private fun getForecastWeather() {
        val city = getCityNameUseCase()
        if (city.isEmpty())
            return
        getForecastWeatherUseCase(city = city).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ForecastWeatherState(
                        weatherList = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _state.value = ForecastWeatherState(
                        error = result.message ?: "An unexpected error happened"
                    )
                }

                is Resource.Loading -> {
                    _state.value = ForecastWeatherState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}