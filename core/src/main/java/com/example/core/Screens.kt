package com.example.core

enum class Screen {
    MainScreen,
    FORECAST
}
sealed class NavItem(val route: String) {
    data object CurrentWeather : NavItem(Screen.MainScreen.name)
    data object Forecast : NavItem(Screen.FORECAST.name)
}