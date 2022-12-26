package com.example.service_nutrients.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.model.nutrient.entity.NutrientItemEntity
import com.example.service_nutrients.dao.NutrientDao

@Database(
    entities = [
        NutrientItemEntity::class
    ],
    version = 1,
)
abstract class NutrientDatabase : RoomDatabase() {

    abstract fun nutrientDao(): NutrientDao

    companion object {
        const val DB_NAME = "nopyjf-android-app-nutrient-db.db"
    }
}