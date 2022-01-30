package com.asurapro.trackinterview.data.module

import android.arch.persistence.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {
    @Query("SELECT * FROM tracker_table ORDER BY id")
    fun getAllTracks(): Flow<List<TrackerModule>>

    @Query("SELECT * FROM tracker_table WHERE id=:trackerID")
    fun getSelectedTracker(trackerID:Int):TrackerModule

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTracker(tracker : TrackerModule)

    @Update
    suspend fun updateTracker(tracker: TrackerModule)

    @Delete
    suspend fun deleteTracker(tracker: TrackerModule)

    @Query("DELETE FROM tracker_table")
    suspend fun deleteAllTracker()

    @Query("SELECT * FROM tracker_table WHERE company LIKE:searchQuery OR lpa LIKE:searchQuery OR description LIKE:searchQuery ")
    fun searchTrackers(searchQuery : String) : Flow<List<TrackerModule>>

    @Query("SELECT * FROM tracker_table ORDER BY date_added")
    fun sortByDateTrackers() : Flow<List<TrackerModule>>

    @Query("SELECT * FROM tracker_table ORDER BY lpa")
    fun sortByLPATrackers() : Flow<List<TrackerModule>>

    @Query("SELECT * FROM tracker_table ORDER BY description")
    fun sortByDescriptionTrackers() : Flow<List<TrackerModule>>
}