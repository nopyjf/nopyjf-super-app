package com.example.service_nutrients.di

import android.content.Context
import androidx.room.Room
import com.example.service_nutrients.dao.NutrientDao
import com.example.service_nutrients.db.NutrientDatabase
import com.example.service_nutrients.db.NutrientDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NutrientModule {

    @Provides
    @Singleton
    fun provideMyDatabase(@ApplicationContext context: Context): NutrientDatabase {
        return Room.databaseBuilder(
            context,
            NutrientDatabase::class.java,
            DB_NAME,
        ).build()
    }

    @Provides
    fun provideNutrientDao(database: NutrientDatabase): NutrientDao {
        return database.nutrientDao()
    }
}