package com.example.data.data_source.current_weather.remote

import com.example.features.weather_screen.domain.entity.CurrentWeatherModel


interface CurrentWeatherRemoteDataSource {
    suspend fun getCurrentWeather(city: String): CurrentWeatherModel
}