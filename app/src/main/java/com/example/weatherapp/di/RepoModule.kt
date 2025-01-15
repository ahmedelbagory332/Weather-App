package com.example.weatherapp.di

import com.example.data.data_source.current_weather.local.CurrentWeatherLocalDataSource
import com.example.data.data_source.current_weather.remote.CurrentWeatherRemoteDataSourceImpl
import com.example.data.data_source.forecast_weather.remote.ForecastWeatherRemoteDataSource
import com.example.data.repo.ForecastWeatherRepoImpl
import com.example.data.repo.WeatherRepoImpl
import com.example.features.forecast_weather_screen.domain.repo.ForecastWeatherRepo
import com.example.features.weather_screen.domain.repo.WeatherRepo
import com.example.weatherapp.data.data_source.ThemeDataSource
import com.example.weatherapp.data.repo.MainRepoImpl
import com.example.weatherapp.domain.repo.MainRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun weatherRepository(
        currentWeatherLocalDataSource: CurrentWeatherLocalDataSource,
        currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSourceImpl,
    ): WeatherRepo =
        WeatherRepoImpl(currentWeatherLocalDataSource, currentWeatherRemoteDataSource)

    @Provides
    @Singleton
    fun forecastWeatherRepository(
        forecastWeatherRemoteDataSource: ForecastWeatherRemoteDataSource,
    ): ForecastWeatherRepo =
        ForecastWeatherRepoImpl(forecastWeatherRemoteDataSource)

    @Provides
    @Singleton
    fun mainRepository(
        themeDataSource: ThemeDataSource,
    ): MainRepo =
        MainRepoImpl(themeDataSource)

}