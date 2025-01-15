package com.example.core

sealed class WeatherType (val name : String){
    data object Temperature : WeatherType("Temperature")
    data object WindSpeed : WeatherType("Wind")
    data object Pressure : WeatherType("Pressure")
    data object Humidity : WeatherType("Humidity")
}


