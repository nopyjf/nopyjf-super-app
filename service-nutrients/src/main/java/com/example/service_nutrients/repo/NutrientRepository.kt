package com.example.service_nutrients.repo

import com.example.model.nutrient.display.NutrientItemDisplay
import com.example.model.nutrient.entity.NutrientItemEntity
import com.example.model.nutrient.entity.transformDisplay
import com.example.model.nutrient.request.NutrientItemRequest
import com.example.model.nutrient.request.transformEntity
import com.example.service_nutrients.dao.NutrientDao
import javax.inject.Inject

class NutrientRepository @Inject constructor(
    private val dao: NutrientDao
) {
    suspend fun getNutrients(): List<NutrientItemDisplay> {
        return dao.getNutrients().map { it.transformDisplay() }
    }

    suspend fun insertNutrient(entity: NutrientItemRequest): NutrientItemEntity {
        dao.insertNutrient(entity.transformEntity())
        return entity.transformEntity()
    }
}