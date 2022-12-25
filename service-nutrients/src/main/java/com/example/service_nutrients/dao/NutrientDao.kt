package com.example.service_nutrients.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.model.nutrient.entity.NutrientItemEntity

@Dao
interface NutrientDao {
    @Query("SELECT * FROM nutrients")
    fun getNutrients(): List<NutrientItemEntity>
}