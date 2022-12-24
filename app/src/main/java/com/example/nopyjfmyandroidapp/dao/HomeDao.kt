package com.example.nopyjfmyandroidapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.nopyjfmyandroidapp.entity.HomeItemEntity

@Dao
interface HomeDao {
    @Query("SELECT * FROM nutrients")
    fun getNutrients(): List<HomeItemEntity>
}