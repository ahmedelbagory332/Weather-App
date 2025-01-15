package com.example.weatherapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.core.NavItem
import com.example.features.forecast_weather_screen.presentaion.ForecastWeatherScreen
import com.example.features.weather_screen.presentaion.WeatherScreen


@Composable
fun App(mainNavController: NavHostController, onThemeClick: () -> Unit) {
    NavHost(
        navController = mainNavController,
        startDestination = NavItem.CurrentWeather.route
    ) {

        composable(route = NavItem.CurrentWeather.route) {
            WeatherScreen(mainNavController, onThemeClick)
        }
        composable(route = NavItem.Forecast.route) {
            ForecastWeatherScreen()
        }

    }

}