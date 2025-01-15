package com.example.features.weather_screen.presentaion


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Resource
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import com.example.features.weather_screen.domain.use_case.CurrentWeatherUseCase
import com.example.features.weather_screen.domain.use_case.GetCityNameUseCase
import com.example.features.weather_screen.domain.use_case.SetCityNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    val currentWeatherUseCase: CurrentWeatherUseCase,
    val getCityNameUseCase: GetCityNameUseCase,
    val setCityNameUseCase: SetCityNameUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val weatherState: StateFlow<WeatherState>
        get() = _state

    init {
        getCurrentWeather()
    }

    fun updateCityName(currentCityName: String) {
        _state.update { state ->
            state.copy(
                searchValue = currentCityName
            )
        }
    }

    fun onSearchClick(currentCityName: String) {
        if (currentCityName.isEmpty())
            return
        setCityNameUseCase(currentCityName)
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        val city = _state.value.searchValue.ifEmpty { getCityNameUseCase() }
        if (city.isEmpty())
            return
        currentWeatherUseCase(city = city).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = WeatherState(
                        weather = result.data ?: CurrentWeatherModel()
                    )
                }

                is Resource.Error -> {
                    _state.value = WeatherState(
                        error = result.message ?: "An unexpected error happened"
                    )
                }

                is Resource.Loading -> {
                    _state.value = WeatherState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}