package com.example.data.data_source.forecast_weather.remote

import com.example.data.api_service.WeatherApi
import com.example.data.mapper.toCurrentWeatherModel
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import javax.inject.Inject

class ForecastWeatherRemoteDataSourceImpl @Inject constructor(
    private val api: WeatherApi,
) : ForecastWeatherRemoteDataSource {
    override suspend fun getForecastWeather(city: String): List<CurrentWeatherModel> {
        return api.getForecastWeather(city = city).data.map { it.toCurrentWeatherModel(city) }
    }
}