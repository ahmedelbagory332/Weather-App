package com.example.features.forecast_weather_screen.presentaion

import com.example.features.weather_screen.domain.entity.CurrentWeatherModel

data class ForecastWeatherState(
    val isLoading: Boolean = false,
    val weatherList: List<CurrentWeatherModel> = emptyList(),
    val error: String = ""
)
