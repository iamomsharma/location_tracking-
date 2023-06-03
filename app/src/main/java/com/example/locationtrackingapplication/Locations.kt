package com.example.locationtrackingapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class Locations(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val date: String
)
