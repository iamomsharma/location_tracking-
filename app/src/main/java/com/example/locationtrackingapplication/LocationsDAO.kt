package com.example.locationtrackingapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocationsDAO {

    @Insert
    suspend fun insertLocation(locations: Locations)

    @Query("SELECT * FROM locations ORDER BY id DESC")
    fun getLocationList() : LiveData<List<Locations>>
}