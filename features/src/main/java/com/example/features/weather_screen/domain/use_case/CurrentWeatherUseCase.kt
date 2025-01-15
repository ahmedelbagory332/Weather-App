package com.example.features.weather_screen.domain.use_case


import com.example.core.Resource
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import com.example.features.weather_screen.domain.repo.WeatherRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepo,
    ) {
    operator fun invoke(city: String): Flow<Resource<CurrentWeatherModel>> = flow {
        try {
            emit(Resource.Loading<CurrentWeatherModel>())
            val genres = repository.getCurrentWeather(city)
            emit(Resource.Success<CurrentWeatherModel>(genres))
        } catch (e: Exception) {
            emit(Resource.Error<CurrentWeatherModel>("${e.localizedMessage} : An unexpected error happened"))
        }
    }
}