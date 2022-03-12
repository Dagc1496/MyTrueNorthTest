package com.example.mytruenorthtest.postList.data.database.dao

import androidx.room.*
import com.example.mytruenorthtest.postList.data.database.entity.PostStateEntity
import com.example.mytruenorthtest.postList.data.database.entity.TopEntity

@Dao
interface TopDao {

    @Insert(entity = TopEntity::class ,onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(top: TopEntity)

    @Query("SELECT * FROM top_table WHERE before_post = :before")
    suspend fun getPage(before: String): List<TopEntity>

    @Update(entity = TopEntity::class)
    suspend fun updateTop(top: TopEntity)

    @Update(entity = PostStateEntity::class)
    suspend fun updatePostState(postWithStateChange: PostStateEntity)
}