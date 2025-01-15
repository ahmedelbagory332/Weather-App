package com.example.data.repo

import com.example.data.data_source.current_weather.local.CurrentWeatherLocalDataSource
import com.example.data.data_source.current_weather.remote.CurrentWeatherRemoteDataSource
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import com.example.features.weather_screen.domain.repo.WeatherRepo
import javax.inject.Inject


class WeatherRepoImpl @Inject constructor(
    private val currentWeatherLocalDataSource: CurrentWeatherLocalDataSource,
    private val currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSource
) : WeatherRepo {

    override suspend fun getCurrentWeather(city: String): CurrentWeatherModel {
        return currentWeatherRemoteDataSource.getCurrentWeather(city)
    }

    override fun setCityName(city: String) {
        currentWeatherLocalDataSource.setCityName(city)

    }

    override fun getCityName(): String {
        return currentWeatherLocalDataSource.getCityName()
    }
}