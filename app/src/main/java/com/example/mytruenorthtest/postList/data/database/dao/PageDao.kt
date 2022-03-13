package com.example.mytruenorthtest.postList.data.database.dao

import androidx.room.*
import com.example.mytruenorthtest.postList.data.database.entity.PageEntity

@Dao
interface PageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPage(page: PageEntity)

    @Transaction
    @Update
    suspend fun updateTop(page: PageEntity)

    @Transaction
    @Query("DELETE FROM page_table")
    fun deleteAll()
}