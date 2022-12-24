package com.example.nopyjfmyandroidapp.action

import com.example.nopyjfmyandroidapp.display.HomeDisplay

sealed class HomeAction(
    val data: HomeDisplay = HomeDisplay()
) {
    object Idle : HomeAction()
    class Success(data: HomeDisplay) : HomeAction(data)
    class AddItemSuccess(data: HomeDisplay) : HomeAction(data)
}