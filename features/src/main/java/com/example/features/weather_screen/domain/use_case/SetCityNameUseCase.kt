package com.example.features.weather_screen.domain.use_case


import com.example.features.weather_screen.domain.repo.WeatherRepo
import javax.inject.Inject

class SetCityNameUseCase @Inject constructor(
    private val repository: WeatherRepo,
) {
    operator fun invoke(city: String) = repository.setCityName(city)
}