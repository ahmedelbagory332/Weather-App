package com.example.data.repo

import com.example.data.data_source.forecast_weather.remote.ForecastWeatherRemoteDataSource
import com.example.features.forecast_weather_screen.domain.repo.ForecastWeatherRepo
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import javax.inject.Inject


class ForecastWeatherRepoImpl @Inject constructor(
    private val forecastWeatherRemoteDataSource: ForecastWeatherRemoteDataSource,
) : ForecastWeatherRepo {
    override suspend fun getForecastWeather(city: String): List<CurrentWeatherModel> {
        return forecastWeatherRemoteDataSource.getForecastWeather(city = city)
    }
}