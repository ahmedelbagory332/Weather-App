package com.example.weatherapp.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.presentation.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mainViewModel: MainViewModel = hiltViewModel()
            val isDarkTheme = mainViewModel.isDarkTheme()
            WeatherAppTheme(
                darkTheme = isDarkTheme
            ) {
                App(rememberNavController()) {
                    mainViewModel.setDarkTheme(!isDarkTheme)
                    restartActivity(this)
                }
            }
        }
    }
}

fun restartActivity(activity: Activity) {
    val intent = Intent(activity, activity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    activity.startActivity(intent)
    activity.finish()
}
