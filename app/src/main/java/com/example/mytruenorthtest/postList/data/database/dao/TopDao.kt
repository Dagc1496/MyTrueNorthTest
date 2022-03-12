package com.example.mytruenorthtest.postList.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mytruenorthtest.postList.data.database.entity.TopEntity

@Dao
interface TopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(top: TopEntity)

    @Query("SELECT * FROM top_table WHERE before_post = :before")
    suspend fun getPage(before: String): List<TopEntity>
}