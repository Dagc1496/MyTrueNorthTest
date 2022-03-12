package com.example.mytruenorthtest.postList.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytruenorthtest.postList.data.database.dao.TopDao
import com.example.mytruenorthtest.postList.data.database.entity.TopEntity

@Database(entities = [TopEntity::class], version = 1)
abstract class TopDatabase : RoomDatabase() {

    abstract fun getTopDao(): TopDao

}