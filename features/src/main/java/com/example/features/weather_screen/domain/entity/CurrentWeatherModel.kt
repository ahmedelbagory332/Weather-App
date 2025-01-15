package com.example.features.weather_screen.domain.entity

data class CurrentWeatherModel(
    val time: String = "",
    val temp: Float = 0f,
    val humidity: Float = 0f,
    val windSpeed: Float = 0f,
    val pressure: Float = 0f,
    val cityName: String = "",
    val iconUrl: String? = null,
    val description: String = ""
)