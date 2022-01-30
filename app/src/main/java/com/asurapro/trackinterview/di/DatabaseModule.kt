package com.asurapro.trackinterview.di

import android.arch.persistence.room.Room
import android.content.Context
import com.asurapro.trackinterview.data.module.TrackerDatabase
import com.asurapro.trackinterview.utils.Constants.MAIN_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    )= Room.databaseBuilder(
        context,
        TrackerDatabase::class.java,
        MAIN_TABLE
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: TrackerDatabase) = database.trackerDao()
}