package com.example.features.forecast_weather_screen.domain.repo

import com.example.features.weather_screen.domain.entity.CurrentWeatherModel


interface ForecastWeatherRepo {
    suspend fun getForecastWeather(city: String): List<CurrentWeatherModel>
}