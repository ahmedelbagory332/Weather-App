package com.example.weatherapp.data.repo

import com.example.weatherapp.data.data_source.ThemeDataSource
import com.example.weatherapp.domain.repo.MainRepo
import javax.inject.Inject


class MainRepoImpl @Inject constructor(
    private val themeDataSource: ThemeDataSource,
) : MainRepo {
    override fun isDarkTheme(): Boolean =
        themeDataSource.isDarkTheme()

    override fun setDarkTheme(isDarkTheme: Boolean) {
        themeDataSource.setDarkTheme(isDarkTheme)
    }

}