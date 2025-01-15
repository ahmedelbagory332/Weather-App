package com.example.features.forecast_weather_screen.presentaion

sealed class ForecastWeatherIntent {
    data object GetForecastWeather : ForecastWeatherIntent()
}