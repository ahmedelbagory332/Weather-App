package com.example.core

fun String?.generateUrlFromIconCode(): String? =
    if (!this.isNullOrEmpty())
        "https://cdn.weatherbit.io/static/img/icons/$this.png"
    else this
