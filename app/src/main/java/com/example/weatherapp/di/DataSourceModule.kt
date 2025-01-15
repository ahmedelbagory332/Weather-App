package com.example.weatherapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.api_service.WeatherApi
import com.example.data.data_source.current_weather.local.CurrentWeatherLocalDataSource
import com.example.data.data_source.current_weather.local.CurrentWeatherLocalDataSourceImpl
import com.example.data.data_source.current_weather.remote.CurrentWeatherRemoteDataSource
import com.example.data.data_source.current_weather.remote.CurrentWeatherRemoteDataSourceImpl
import com.example.data.data_source.forecast_weather.remote.ForecastWeatherRemoteDataSource
import com.example.data.data_source.forecast_weather.remote.ForecastWeatherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    private const val PREF_NAME = "my_preferences"

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun currentWeatherRemoteDataSource(api: WeatherApi): CurrentWeatherRemoteDataSource =
        CurrentWeatherRemoteDataSourceImpl(api)

    @Provides
    @Singleton
    fun currentWeatherLocalDataSource(
        sharedPreferences: SharedPreferences
    ): CurrentWeatherLocalDataSource =
        CurrentWeatherLocalDataSourceImpl(sharedPreferences)


    @Provides
    @Singleton
    fun forecastWeatherRemoteDataSource(
        api: WeatherApi
    ): ForecastWeatherRemoteDataSource =
        ForecastWeatherRemoteDataSourceImpl(api)

}