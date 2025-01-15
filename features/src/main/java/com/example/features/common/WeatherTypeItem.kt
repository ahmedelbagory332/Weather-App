package com.example.features.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WeatherTypeItem(modifier: Modifier = Modifier, conditionValue: String, conditionLabel: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = conditionValue,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = modifier.height(5.dp))
        Text(
            text = conditionLabel,
            style = MaterialTheme.typography.labelSmall,
            color = Color.DarkGray
        )
    }
}