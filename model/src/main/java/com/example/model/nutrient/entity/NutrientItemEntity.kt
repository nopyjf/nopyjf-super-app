package com.example.model.nutrient.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nutrients")
data class NutrientItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = -1,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "protein_weight") val proteinWeight: Double = 0.0,
)