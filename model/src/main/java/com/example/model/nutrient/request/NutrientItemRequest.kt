package com.example.model.nutrient.request

import com.example.model.nutrient.display.NutrientItemDisplay
import com.example.model.nutrient.entity.NutrientItemEntity

data class NutrientItemRequest(
    val title: String = "",
    val proteinWeight: Double = 0.0,
)

fun NutrientItemRequest.transformDisplay(): NutrientItemDisplay {
    return NutrientItemDisplay(
        title = this.title,
        proteinWeight = this.proteinWeight
    )
}

fun NutrientItemRequest.transformEntity(): NutrientItemEntity {
    return NutrientItemEntity(
        title = this.title,
        proteinWeight = this.proteinWeight
    )
}