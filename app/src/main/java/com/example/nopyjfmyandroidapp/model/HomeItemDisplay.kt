package com.example.nopyjfmyandroidapp.model

data class HomeDisplay(
    val items: List<HomeItemDisplay> = listOf()
)

data class HomeItemDisplay(
    val title: String = "",
    val proteinWeight: Double = 0.0,
)