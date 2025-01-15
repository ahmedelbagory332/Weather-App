package com.example.data.api_service.entity

import com.google.gson.annotations.SerializedName

data class ForecastWeatherNetWorkEntity(
    @SerializedName("city_name") var cityName: String? = null,
    @SerializedName("country_code") var countryCode: String? = null,
    @SerializedName("data") var data: ArrayList<ForecastWeatherNetWorkEntityData> = arrayListOf(),
    @SerializedName("lat") var lat: String? = null,
    @SerializedName("lon") var lon: String? = null,
    @SerializedName("state_code") var stateCode: String? = null,
    @SerializedName("timezone") var timezone: String? = null
)

data class ForecastWeatherNetWorkEntityData(
    @SerializedName("app_max_temp") var appMaxTemp: Float? = null,
    @SerializedName("app_min_temp") var appMFloatemp: Float? = null,
    @SerializedName("clouds") var clouds: Float? = null,
    @SerializedName("clouds_hi") var cloudsHi: Float? = null,
    @SerializedName("clouds_low") var cloudsLow: Float? = null,
    @SerializedName("clouds_mid") var cloudsMid: Float? = null,
    @SerializedName("datetime") var datetime: String? = null,
    @SerializedName("dewpt") var dewpt: Float? = null,
    @SerializedName("high_temp") var highTemp: Float? = null,
    @SerializedName("low_temp") var lowTemp: Float? = null,
    @SerializedName("max_dhi") var maxDhi: String? = null,
    @SerializedName("max_temp") var maxTemp: Float? = null,
    @SerializedName("min_temp") var mFloatemp: Float? = null,
    @SerializedName("moon_phase") var moonPhase: Float? = null,
    @SerializedName("moon_phase_lunation") var moonPhaseLunation: Float? = null,
    @SerializedName("moonrise_ts") var moonriseTs: Float? = null,
    @SerializedName("moonset_ts") var moonsetTs: Float? = null,
    @SerializedName("ozone") var ozone: Float? = null,
    @SerializedName("pop") var pop: Float? = null,
    @SerializedName("precip") var precip: Float? = null,
    @SerializedName("pres") var pres: Float? = null,
    @SerializedName("rh") var rh: Float? = null,
    @SerializedName("slp") var slp: Float? = null,
    @SerializedName("snow") var snow: Float? = null,
    @SerializedName("snow_depth") var snowDepth: Float? = null,
    @SerializedName("sunrise_ts") var sunriseTs: Float? = null,
    @SerializedName("sunset_ts") var sunsetTs: Float? = null,
    @SerializedName("temp") var temp: Float? = null,
    @SerializedName("ts") var ts: Float? = null,
    @SerializedName("uv") var uv: Float? = null,
    @SerializedName("valid_date") var validDate: String? = null,
    @SerializedName("vis") var vis: Float? = null,
    @SerializedName("weather") var weather: Weather? = Weather(),
    @SerializedName("wind_cdir") var windCdir: String? = null,
    @SerializedName("wind_cdir_full") var windCdirFull: String? = null,
    @SerializedName("wind_dir") var windDir: Float? = null,
    @SerializedName("wind_gust_spd") var windGustSpd: Float? = null,
    @SerializedName("wind_spd") var windSpd: Float? = null
)