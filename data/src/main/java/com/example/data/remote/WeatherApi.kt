package com.example.data.remote

import com.example.data.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current")
    suspend fun getCurrentWeather(
        @Query("key") key: String = BuildConfig.API_Key,
        @Query("city") city: String,
    ): CurrentWeatherNetWorkEntity

}