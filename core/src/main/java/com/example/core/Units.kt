package com.example.core

sealed class Units (val name:String){
    data object TemperatureUnit : Units("C")
    data object WindSpeedUnit : Units("m/s")
    data object PressureUnit : Units("mb")
    data object HumidityUnit : Units("%")
}