package com.example.data.data_source.current_weather.local

import android.content.SharedPreferences
import com.example.core.CITY_KEY
import javax.inject.Inject

class CurrentWeatherLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : CurrentWeatherLocalDataSource {
    override fun setCityName(city: String) {
        sharedPreferences.edit().putString(CITY_KEY, city).apply()

    }

    override fun getCityName(): String {
        return sharedPreferences.getString(CITY_KEY, "") ?: ""
    }
}