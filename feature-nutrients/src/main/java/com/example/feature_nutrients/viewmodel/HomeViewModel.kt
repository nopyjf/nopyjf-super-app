package com.example.feature_nutrients.viewmodel

import androidx.lifecycle.ViewModel
import com.example.feature_nutrients.action.HomeAction
import com.example.model.nutrient.display.NutrientItemDisplay
import com.example.model.nutrient.request.NutrientItemRequest
import com.example.model.nutrient.request.transformDisplay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<HomeAction>(HomeAction.Idle)

    val state: StateFlow<HomeAction> = _state.asStateFlow()

    init {
        val data = arrayListOf(
            NutrientItemDisplay(
                title = "Kao Mun Gai",
                proteinWeight = 10.0,
            ),
            NutrientItemDisplay(
                title = "Kao Kra Pao Gai",
                proteinWeight = 10.0,
            ),
            NutrientItemDisplay(
                title = "Chicken Chest",
                proteinWeight = 20.0,
            ),
        )

        _state.value = HomeAction.Success(items = data)
    }

    fun addItem(item: NutrientItemRequest) {
        _state.update {
            it.items.add(item.transformDisplay())
            HomeAction.AddItemSuccess(items = it.items)
        }
    }

    fun getItems(): ArrayList<NutrientItemDisplay> = _state.value.items
}