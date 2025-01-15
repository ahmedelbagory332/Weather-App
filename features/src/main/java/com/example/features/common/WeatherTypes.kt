package com.example.features.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.Units
import com.example.core.WeatherType
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import kotlin.math.roundToInt

@Composable
fun WeatherTypes(modifier: Modifier = Modifier, weather : CurrentWeatherModel) {
    Card(
        modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = CircleShape,
    ) {
        Row(
            modifier = modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WeatherTypeItem(
                conditionValue = "${weather.windSpeed.roundToInt()} ${Units.WindSpeedUnit.name}",
                conditionLabel = WeatherType.WindSpeed.name
            )
            VerticalDivider()
            WeatherTypeItem(
                conditionValue = "${weather.pressure.roundToInt()} ${Units.PressureUnit.name}",
                conditionLabel = WeatherType.Pressure.name
            )
            VerticalDivider()
            WeatherTypeItem(
                conditionValue = "${weather.humidity.roundToInt()} ${Units.HumidityUnit.name}",
                conditionLabel = WeatherType.Humidity.name
            )
        }

    }

}
