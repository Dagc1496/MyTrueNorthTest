package com.example.mytruenorthtest.postList.domain.useCase

import com.example.mytruenorthtest.postList.domain.repository.IPostRepository
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(private val postRepository: IPostRepository) {
    suspend operator fun invoke(title: String) {
        try {
            postRepository.deletePost(title)
        } catch (exception: Exception) {
            /*
                Do some analitycs because database is failing
             */
        }
    }
}