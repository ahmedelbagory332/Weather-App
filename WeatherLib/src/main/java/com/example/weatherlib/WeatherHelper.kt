package com.example.weatherlib

object WeatherHelper {

    fun formatIconUrl(iconCode: String?) =
        if (!iconCode.isNullOrEmpty())
            "https://cdn.weatherbit.io/static/img/icons/$iconCode.png"
        else iconCode
}