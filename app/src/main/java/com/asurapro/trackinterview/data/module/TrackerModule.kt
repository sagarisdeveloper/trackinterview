package com.asurapro.trackinterview.data.module

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.asurapro.trackinterview.utils.Constants.MAIN_TABLE

@Entity(tableName = MAIN_TABLE)
data class TrackerModule(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val company: String,
    val date_added: String,
    val lpa: String,
    val description: String
)