package com.example.features.forecast_weather_screen.domain.use_case


import com.example.core.Resource
import com.example.features.forecast_weather_screen.domain.repo.ForecastWeatherRepo
import com.example.features.weather_screen.domain.entity.CurrentWeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetForecastWeatherUseCase @Inject constructor(
    private val repository: ForecastWeatherRepo,
    ) {
    operator fun invoke(city: String): Flow<Resource<List<CurrentWeatherModel>>> = flow {
        try {
            emit(Resource.Loading<List<CurrentWeatherModel>>())
            val weatherList = repository.getForecastWeather(city)
            emit(Resource.Success<List<CurrentWeatherModel>>(weatherList.take(7)))
        } catch (e: Exception) {
            emit(Resource.Error<List<CurrentWeatherModel>>("${e.localizedMessage} : An unexpected error happened"))
        }
    }
}