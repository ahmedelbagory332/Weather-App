package com.example.weatherapp.data.data_source


interface ThemeDataSource {
    fun isDarkTheme(): Boolean
    fun setDarkTheme(isDarkTheme: Boolean)
}