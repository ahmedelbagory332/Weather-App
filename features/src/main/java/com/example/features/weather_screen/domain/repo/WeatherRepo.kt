package com.example.features.weather_screen.domain.repo

import com.example.features.weather_screen.domain.entity.CurrentWeatherModel


interface WeatherRepo {
    suspend fun getCurrentWeather(city: String): CurrentWeatherModel
    fun setCityName(city: String)
    fun getCityName(): String
}