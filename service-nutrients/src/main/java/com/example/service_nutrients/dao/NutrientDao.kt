package com.example.service_nutrients.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.model.nutrient.entity.NutrientItemEntity

@Dao
interface NutrientDao {
    @Query("SELECT * FROM nutrients")
    suspend fun getNutrients(): List<NutrientItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutrient(request: NutrientItemEntity)
}