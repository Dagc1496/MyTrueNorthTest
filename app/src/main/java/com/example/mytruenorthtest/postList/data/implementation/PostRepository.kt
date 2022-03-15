package com.example.mytruenorthtest.postList.data.implementation

import com.example.mytruenorthtest.postList.data.database.dao.PostDao
import com.example.mytruenorthtest.postList.data.mapToEntity
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.repository.IPostRepository
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postDao: PostDao
) : IPostRepository {

    override suspend fun updatePostState(post: Post){
        postDao.updatePostState(post.mapToEntity())
    }

    override suspend fun deletePost(title: String) {
        postDao.deletePost(title)
    }
}