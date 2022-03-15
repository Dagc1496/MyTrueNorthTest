package com.example.mytruenorthtest.postList.domain.useCase

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.repository.IPostRepository
import javax.inject.Inject

class UpdatePostStateUseCase @Inject constructor(private val postRepository: IPostRepository) {
    suspend operator fun invoke(post: Post) {
        try {
            postRepository.updatePostState(post)
        } catch (exception: Exception) {
            /*
                Do some analitycxs because database is failing
             */
        }
    }
}