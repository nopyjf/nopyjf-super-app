package com.example.nopyjfmyandroidapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nopyjfmyandroidapp.action.HomeAction
import com.example.nopyjfmyandroidapp.model.HomeDisplay
import com.example.nopyjfmyandroidapp.model.HomeItemDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<HomeAction>(HomeAction.Idle)

    val state: StateFlow<HomeAction> = _state.asStateFlow()

    fun getItems() {
        val data = HomeDisplay(
            items = listOf(
                HomeItemDisplay(
                    title = "Kao Mun Gai",
                    proteinWeight = 10.0,
                ),
                HomeItemDisplay(
                    title = "Kao Kra Pao Gai",
                    proteinWeight = 10.0,
                ),
                HomeItemDisplay(
                    title = "Chicken Chest",
                    proteinWeight = 20.0,
                ),
            )
        )

        _state.value = HomeAction.Success(data = data)
    }
}