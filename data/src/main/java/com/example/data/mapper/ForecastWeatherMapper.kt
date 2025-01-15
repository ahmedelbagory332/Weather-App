package com.example.data.mapper

import com.example.core.generateUrlFromIconCode
import com.example.data.api_service.entity.ForecastWeatherNetWorkEntityData
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel

fun ForecastWeatherNetWorkEntityData.toCurrentWeatherModel(cityName:String): CurrentWeatherModel =
    CurrentWeatherModel(
        time = datetime ?: "",
        temp = temp ?: 0f,
        humidity = rh ?: 0f,
        windSpeed = windSpd ?: 0f,
        pressure = pres ?: 0f,
        cityName = cityName,
        iconUrl = weather?.icon.let { it.generateUrlFromIconCode() }
    )