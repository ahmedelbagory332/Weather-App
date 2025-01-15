package com.example.weatherapp.domain.repo


interface MainRepo {
     fun isDarkTheme(): Boolean
     fun setDarkTheme(isDarkTheme: Boolean)
}