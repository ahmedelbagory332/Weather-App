package com.example.features.weather_screen.presentaion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.features.R
import com.example.features.common.LoadingIndicator
import com.example.features.common.PlaceHolder
import com.example.features.common.TopBar
import com.example.features.common.WeatherInfoItem
import com.example.features.weather_screen.presentaion.widget.SearchBar

@Composable
fun WeatherScreen(
    mainNavController: NavHostController,
    weatherViewModel: WeatherViewModel = hiltViewModel()
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val uiState by weatherViewModel.weatherState.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(title = stringResource(R.string.weather))
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SearchBar(
                focusRequester = focusRequester,
                focusManager = focusManager,
                value = uiState.searchValue,
                onValueChange = weatherViewModel::updateCityName,
                onSearchClick = {
                    weatherViewModel.onSearchClick(it)
                }
            )
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
                uiState.weather.cityName.isNotEmpty() -> {
                    WeatherInfoItem(
                        modifier = Modifier
                            .padding(10.dp),
                        weather = uiState.weather
                    )
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
