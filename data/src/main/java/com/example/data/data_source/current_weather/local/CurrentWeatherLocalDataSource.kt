package com.example.data.data_source.current_weather.local


interface CurrentWeatherLocalDataSource {
    fun setCityName(city: String)
    fun getCityName(): String
}