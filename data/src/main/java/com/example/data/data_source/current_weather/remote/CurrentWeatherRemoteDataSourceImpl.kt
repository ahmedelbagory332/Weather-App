package com.example.data.data_source.current_weather.remote

import com.example.data.api_service.WeatherApi
import com.example.data.mapper.toCurrentWeatherModel
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import javax.inject.Inject

class CurrentWeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherApi,
) : CurrentWeatherRemoteDataSource {
    override suspend fun getCurrentWeather(city: String): CurrentWeatherModel {
        return api.getCurrentWeather(city = city).data[0].toCurrentWeatherModel()
    }
}