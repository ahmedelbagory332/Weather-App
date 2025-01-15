package com.example.data.api_service

import com.example.data.BuildConfig
import com.example.data.api_service.entity.CurrentWeatherNetWorkEntity
import com.example.data.api_service.entity.ForecastWeatherNetWorkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current")
    suspend fun getCurrentWeather(
        @Query("key") key: String = BuildConfig.API_Key,
        @Query("city") city: String,
    ): CurrentWeatherNetWorkEntity

    @GET("forecast/daily")
    suspend fun getForecastWeather(
        @Query("key") key: String = BuildConfig.API_Key,
        @Query("city") city: String,
    ): ForecastWeatherNetWorkEntity

}