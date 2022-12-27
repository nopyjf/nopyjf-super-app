package com.example.feature_nutrients.action

import com.example.model.nutrient.display.NutrientItemDisplay


sealed class HomeAction(
    val items: ArrayList<NutrientItemDisplay> = arrayListOf()
) {
    object Idle : HomeAction()

    class Success(
        items: ArrayList<NutrientItemDisplay>
    ) : HomeAction(items)

    class AddItemSuccess(
        items: ArrayList<NutrientItemDisplay>
    ) : HomeAction(items)

    class AddItemFailed(
        e: Throwable
    ) : HomeAction()
}