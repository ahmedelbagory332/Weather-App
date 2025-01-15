package com.example.data.data_source.forecast_weather.remote

import com.example.features.weather_screen.domain.entity.CurrentWeatherModel

interface ForecastWeatherRemoteDataSource {
    suspend fun getForecastWeather(city: String): List<CurrentWeatherModel>
}