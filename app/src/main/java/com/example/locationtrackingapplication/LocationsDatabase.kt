package com.example.locationtrackingapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Locations::class], version = 1)
abstract class LocationsDatabase : RoomDatabase() {

    abstract fun locationsDao(): LocationsDAO

    companion object {
        @Volatile
        private var INSTANCE: LocationsDatabase? = null

        fun getDatabase(context: Context): LocationsDatabase {
            if (INSTANCE == null) {

                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        LocationsDatabase::class.java,
                        "locationDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}