package com.asurapro.trackinterview.data.repository

import com.asurapro.trackinterview.data.module.TrackerDao
import com.asurapro.trackinterview.data.module.TrackerModule
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val trackerDao: TrackerDao) {
    val getAllTrackers: Flow<List<TrackerModule>> = trackerDao.getAllTracks()
    val sortByDateTrackers: Flow<List<TrackerModule>> = trackerDao.sortByDateTrackers()

    fun getSelectedTracker(trackerID: Int): TrackerModule = trackerDao.getSelectedTracker(trackerID)

    suspend fun addTracker(tracker :TrackerModule) {
        trackerDao.addTracker(tracker)
    }

    suspend fun updateTracker(tracker :TrackerModule) {
        trackerDao.updateTracker(tracker)
    }

    suspend fun deleteTracker(tracker :TrackerModule) {
        trackerDao.deleteTracker(tracker)
    }

    suspend fun deleteAll() {
        trackerDao.deleteAllTracker()
    }

    fun searchTrackers(searchQuery : String): Flow<List<TrackerModule>> = trackerDao.searchTrackers(searchQuery)

}