package com.example.mytruenorthtest.postList.data.implementation

import com.example.mytruenorthtest.postList.data.database.dao.TopDao
import com.example.mytruenorthtest.postList.data.mapToStateEntity
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.repository.IPostRepository
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val topDao: TopDao
) : IPostRepository {

    override suspend fun updatePostState(post: Post) {
        topDao.updatePostState(post.mapToStateEntity())
    }
}