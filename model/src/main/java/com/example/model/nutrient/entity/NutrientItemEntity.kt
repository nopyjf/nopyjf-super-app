package com.example.model.nutrient.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.nutrient.display.NutrientItemDisplay


@Entity(tableName = "nutrients")
data class NutrientItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = -1,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "protein_weight") val proteinWeight: Double = 0.0,
)

fun NutrientItemEntity.transformDisplay(): NutrientItemDisplay {
    return NutrientItemDisplay(
        id = this.id,
        title = this.title,
        proteinWeight = this.proteinWeight
    )
}