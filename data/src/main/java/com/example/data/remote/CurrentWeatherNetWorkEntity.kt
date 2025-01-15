package com.example.data.remote

import com.google.gson.annotations.SerializedName


data class CurrentWeatherNetWorkEntity(
    @SerializedName("count") var count: Float? = null,
    @SerializedName("data") var data: ArrayList<CurrentWeatherNetWorkEntityData> = arrayListOf()
)

data class Weather(
    @SerializedName("description") var description: String? = null,
    @SerializedName("code") var code: Float? = null,
    @SerializedName("icon") var icon: String? = null
)

data class CurrentWeatherNetWorkEntityData(
    @SerializedName("app_temp") var appTemp: Double? = null,
    @SerializedName("aqi") var aqi: Float? = null,
    @SerializedName("city_name") var cityName: String? = null,
    @SerializedName("clouds") var clouds: Float? = null,
    @SerializedName("country_code") var countryCode: String? = null,
    @SerializedName("datetime") var datetime: String? = null,
    @SerializedName("dewpt") var dewpt: Double? = null,
    @SerializedName("dhi") var dhi: Float? = null,
    @SerializedName("dni") var dni: Float? = null,
    @SerializedName("elev_angle") var elevAngle: Double? = null,
    @SerializedName("ghi") var ghi: Float? = null,
    @SerializedName("gust") var gust: Double? = null,
    @SerializedName("h_angle") var hAngle: Double? = null,
    @SerializedName("lat") var lat: Double? = null,
    @SerializedName("lon") var lon: Double? = null,
    @SerializedName("ob_time") var obTime: String? = null,
    @SerializedName("pod") var pod: String? = null,
    @SerializedName("precip") var precip: Float? = null,
    @SerializedName("pres") var pres: Float? = null,
    @SerializedName("rh") var rh: Float? = null,
    @SerializedName("slp") var slp: Float? = null,
    @SerializedName("snow") var snow: Float? = null,
    @SerializedName("solar_rad") var solarRad: Float? = null,
    @SerializedName("sources") var sources: ArrayList<String> = arrayListOf(),
    @SerializedName("state_code") var stateCode: String? = null,
    @SerializedName("station") var station: String? = null,
    @SerializedName("sunrise") var sunrise: String? = null,
    @SerializedName("sunset") var sunset: String? = null,
    @SerializedName("temp") var temp: Float? = null,
    @SerializedName("timezone") var timezone: String? = null,
    @SerializedName("ts") var ts: Float? = null,
    @SerializedName("uv") var uv: Float? = null,
    @SerializedName("vis") var vis: Float? = null,
    @SerializedName("weather") var weather: Weather? = Weather(),
    @SerializedName("wind_cdir") var windCdir: String? = null,
    @SerializedName("wind_cdir_full") var windCdirFull: String? = null,
    @SerializedName("wind_dir") var windDir: Float? = null,
    @SerializedName("wind_spd") var windSpd: Float? = null
)