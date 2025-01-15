package com.example.weatherapp.data.data_source

import android.content.SharedPreferences
import com.example.core.DARK_THEME_KEY
import javax.inject.Inject

class ThemeDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ThemeDataSource {

    override fun isDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(DARK_THEME_KEY, false)
    }

    override fun setDarkTheme(isDarkTheme: Boolean) {
        sharedPreferences.edit().putBoolean(DARK_THEME_KEY, isDarkTheme).apply()

    }
}