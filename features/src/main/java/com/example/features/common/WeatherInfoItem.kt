package com.example.features.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.core.Units
import com.example.features.R
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import kotlin.math.roundToInt

@Composable
fun WeatherInfoItem(
    modifier: Modifier = Modifier,
    weather: CurrentWeatherModel,
    hideForecast: Boolean = true,
    onForecastClick: () -> Unit = {}
) {

    Card(
        modifier
            .fillMaxWidth()
            .graphicsLayer {
                scaleX = 1.02f
                scaleY = 1.02f

            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weather.cityName,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = weather.time,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(20.dp))
            if (!weather.iconUrl.isNullOrEmpty())
                AsyncImage(
                    model = weather.iconUrl,
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
            else
                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = ""
                )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "${weather.temp.roundToInt()} ${Units.TemperatureUnit.name}",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = weather.description,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.height(20.dp))
            WeatherTypes(Modifier, weather = weather)
            if (!hideForecast) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Show Forecast for next 7 days",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clickable {
                        onForecastClick()
                    }
                )
            }
        }
    }

}
