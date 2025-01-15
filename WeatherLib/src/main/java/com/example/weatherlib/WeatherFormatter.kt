package com.example.weatherlib

import android.annotation.SuppressLint


@SuppressLint("DefaultLocale")
object WeatherFormatter {
    fun formatTemperature(temperature: Double): String {
        return String.format("%.1f°C", temperature)
    }

    fun formatWindSpeed(speed: Double): String {
        return String.format("%.1f km/h", speed)
    }
}
