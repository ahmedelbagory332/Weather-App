package com.example.features.weather_screen.presentaion.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.features.R
import kotlinx.coroutines.delay


@Composable
fun SearchBar(
    focusRequester: FocusRequester,
    focusManager: FocusManager,
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick: (String) -> Unit
) {
    LaunchedEffect(Unit) {
        delay(200)
        focusRequester.requestFocus()
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .focusRequester(focusRequester),
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.enter_city_name)) },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                onSearchClick(value)
            }

        )
    )
}