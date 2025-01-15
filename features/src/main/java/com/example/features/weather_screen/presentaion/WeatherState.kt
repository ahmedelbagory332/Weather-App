package com.example.features.weather_screen.presentaion

import com.example.features.weather_screen.domain.entity.CurrentWeatherModel

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: CurrentWeatherModel = CurrentWeatherModel(),
    val error: String = "",
    val searchValue: String = ""
)
