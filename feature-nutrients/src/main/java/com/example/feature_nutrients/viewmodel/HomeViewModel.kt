package com.example.feature_nutrients.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_nutrients.action.HomeAction
import com.example.model.nutrient.display.NutrientItemDisplay
import com.example.model.nutrient.entity.transformDisplay
import com.example.model.nutrient.request.NutrientItemRequest
import com.example.model.nutrient.request.transformDisplay
import com.example.model.nutrient.request.transformEntity
import com.example.service_nutrients.repo.NutrientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: NutrientRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<HomeAction>(HomeAction.Idle)

    val state: StateFlow<HomeAction> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val data = repo.getNutrients() as ArrayList
            _state.value = HomeAction.Success(items = data)
        }
    }

    fun addItem(request: NutrientItemRequest) {
        viewModelScope.launch {
            _state.update {
                try {
                    val item = repo.insertNutrient(request)
                    it.items.add(item.transformDisplay())
                    HomeAction.AddItemSuccess(items = it.items)
                } catch (e: Exception) {
                    HomeAction.AddItemFailed(e)
                }
            }
        }
    }

    fun getItems(): ArrayList<NutrientItemDisplay> = _state.value.items
}