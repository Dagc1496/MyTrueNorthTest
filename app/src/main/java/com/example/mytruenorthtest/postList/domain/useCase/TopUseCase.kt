package com.example.mytruenorthtest.postList.domain.useCase

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.repository.IPageRepository
import java.lang.Exception
import javax.inject.Inject

class TopUseCase @Inject constructor(private val pageRepository: IPageRepository){

    suspend operator fun invoke(after: String? = null): Result<Page> {
        try {
            val topPage: Page = pageRepository.fetchTopPage(after)
            return Result.success(topPage)
        } catch (exception: Exception) {
            return if (exception is NoDataRecivedException) {
                /*
                            normally generate logs since the server is not delivering all the necessary information
                            think about it like an anti-corruption layer

                            Just for sonar issues return IllegalArgumentException() instead of exception, normally the issue of the
                            same code block should not appear with the implementation of logs or analytics.
                         */
                Result.failure(java.lang.IllegalArgumentException())
            } else {
                Result.failure(exception)
            }
        }
    }
}