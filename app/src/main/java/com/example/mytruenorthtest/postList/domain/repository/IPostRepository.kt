package com.example.mytruenorthtest.postList.domain.repository

import com.example.mytruenorthtest.postList.domain.model.Post

interface IPostRepository {

    suspend fun updatePostState(post: Post)

}