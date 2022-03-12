package com.example.mytruenorthtest.postList.domain.repository

import com.example.mytruenorthtest.postList.domain.model.Post

interface IPostRepository {

    fun updatePostState(post: Post)

}