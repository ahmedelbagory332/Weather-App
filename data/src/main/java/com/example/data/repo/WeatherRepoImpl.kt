package com.example.data.repo

import android.content.SharedPreferences
import com.example.core.CITY_KEY
import com.example.data.remote.WeatherApi
import com.example.data.toCurrentWeatherModel
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import com.example.features.weather_screen.domain.repo.WeatherRepo
import javax.inject.Inject


class WeatherRepoImpl @Inject constructor(
    private val api: WeatherApi,
    private val sharedPreferences: SharedPreferences
) : WeatherRepo {

    override suspend fun getCurrentWeather(city: String): CurrentWeatherModel {
        return api.getCurrentWeather(city = city).data[0].toCurrentWeatherModel()
    }

    override fun setCityName(city: String) {
        sharedPreferences.edit().putString(CITY_KEY, city).apply()

    }

    override fun getCityName(): String {
        return sharedPreferences.getString(CITY_KEY, "") ?: ""
    }
}