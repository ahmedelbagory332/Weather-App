package com.example.weatherapp.domain.use_case

import com.example.weatherapp.domain.repo.MainRepo
import javax.inject.Inject

class SetDarkThemeUseCase @Inject constructor(
    private val repository: MainRepo,
) {
    operator fun invoke(isDarkTheme: Boolean) = repository.setDarkTheme(isDarkTheme)
}