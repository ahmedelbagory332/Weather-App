package com.example.weatherapp.presentation

import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.use_case.GetDarkThemeUseCase
import com.example.weatherapp.domain.use_case.SetDarkThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getDarkThemeUseCase: GetDarkThemeUseCase,
    val setDarkThemeUseCase: SetDarkThemeUseCase,
) : ViewModel() {

    fun isDarkTheme(): Boolean = getDarkThemeUseCase()

    fun setDarkTheme(isDarkTheme: Boolean) = setDarkThemeUseCase(isDarkTheme)
}