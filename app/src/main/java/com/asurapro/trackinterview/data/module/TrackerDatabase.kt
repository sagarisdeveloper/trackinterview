package com.asurapro.trackinterview.data.module

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [TrackerModule::class], version = 1, exportSchema = false)
abstract class TrackerDatabase : RoomDatabase()   {
    abstract fun trackerDao(): TrackerDao

}