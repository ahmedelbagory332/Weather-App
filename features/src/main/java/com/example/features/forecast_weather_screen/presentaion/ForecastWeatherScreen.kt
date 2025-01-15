package com.example.features.forecast_weather_screen.presentaion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.features.R
import com.example.features.common.LoadingIndicator
import com.example.features.common.PlaceHolder
import com.example.features.common.TopBar
import com.example.features.common.WeatherInfoItem

@Composable
fun ForecastWeatherScreen(
    forecastWeatherViewModel: ForecastWeatherViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        forecastWeatherViewModel.sendIntent(ForecastWeatherIntent.GetForecastWeather)
    }

    val uiState by forecastWeatherViewModel.forecastWeatherState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(title = stringResource(R.string.forecast_weather))
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            when{
                uiState.isLoading -> {
                    LoadingIndicator()
                }
                uiState.error.isNotEmpty() -> {
                    PlaceHolder(
                        text = uiState.error,
                        painter = painterResource(id = R.drawable.error)
                    )

                }
                uiState.weatherList.isNotEmpty() -> {
                    LazyColumn {
                        items(uiState.weatherList) { weather ->
                            WeatherInfoItem(
                                modifier = Modifier
                                    .padding(10.dp),
                                weather = weather
                            )
                        }
                    }
                }
                else -> {
                    PlaceHolder(
                        text = stringResource(R.string.enter_city_name_to_get_weather),
                        painter = painterResource(id = R.drawable.search)
                    )
                }
            }
        }
    }

}
