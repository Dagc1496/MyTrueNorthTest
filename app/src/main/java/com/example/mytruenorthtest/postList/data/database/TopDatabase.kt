package com.example.mytruenorthtest.postList.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytruenorthtest.postList.data.database.dao.PageDao
import com.example.mytruenorthtest.postList.data.database.dao.PostDao
import com.example.mytruenorthtest.postList.data.database.entity.PageEntity
import com.example.mytruenorthtest.postList.data.database.entity.PostEntity

@Database(entities = [PageEntity::class, PostEntity::class], version = 1)
abstract class TopDatabase : RoomDatabase() {

    abstract fun getPageDao(): PageDao

    abstract fun getPostDao(): PostDao
}