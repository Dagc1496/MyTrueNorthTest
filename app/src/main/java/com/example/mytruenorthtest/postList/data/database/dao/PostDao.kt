package com.example.mytruenorthtest.postList.data.database.dao

import androidx.room.*
import com.example.mytruenorthtest.postList.data.database.entity.PostEntity

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)

    @Update
    suspend fun updatePostState(postWithStateChange: PostEntity)

    @Query("DELETE FROM post_table WHERE title = :title")
    fun deletePost(title : String)
}