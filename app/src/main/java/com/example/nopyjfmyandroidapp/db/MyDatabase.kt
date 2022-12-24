package com.example.nopyjfmyandroidapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nopyjfmyandroidapp.dao.HomeDao
import com.example.nopyjfmyandroidapp.entity.HomeItemEntity

@Database(
    entities = [
        HomeItemEntity::class
    ],
    version = 1,
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao

    companion object {
        @Volatile
        private var instance: MyDatabase? = null

        private const val DB_NAME = "nopyjf-android-app-database"

        operator fun invoke(context: Context) {
            instance ?: synchronized(this) {
                buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): MyDatabase {
            return Room.databaseBuilder(
                context,
                MyDatabase::class.java,
                DB_NAME,
            ).build()
        }
    }
}