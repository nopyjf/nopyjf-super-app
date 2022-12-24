package com.example.nopyjfmyandroidapp.model

data class HomeDisplay(
    val items: ArrayList<HomeItemDisplay> = arrayListOf()
)

data class HomeItemDisplay(
    val title: String = "",
    val proteinWeight: Double = 0.0,
)