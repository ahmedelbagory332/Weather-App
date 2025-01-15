package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.NavItem
import com.example.features.forecast_weather_screen.presentaion.ForecastWeatherScreen
import com.example.features.weather_screen.presentaion.WeatherScreen
import com.example.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                App(rememberNavController())
            }
        }
    }
}

@Composable
fun App(mainNavController: NavHostController) {
    NavHost(
        navController = mainNavController,
        startDestination = NavItem.CurrentWeather.route
    ) {

        composable(route = NavItem.CurrentWeather.route) {
            WeatherScreen(mainNavController)
        }
        composable(route = NavItem.Forecast.route) {
            ForecastWeatherScreen()
        }

    }

}
