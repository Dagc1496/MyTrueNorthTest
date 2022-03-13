package com.example.mytruenorthtest.postList.domain.useCase

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.repository.IPageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TopUseCase @Inject constructor(private val pageRepository: IPageRepository){

    operator fun invoke(after: String? = null): Flow<Result<Page>> {
        return flow {
            val topPage:Page = pageRepository.fetchTopPage(after)
            val result = Result.success(topPage)
            emit(result)
        }.catch { exception ->
            if(exception is NoDataRecivedException){
                /*
                    normally generate logs since the server is not delivering all the necessary information
                    think about it like an anti-corruption layer

                    Just for sonar issues return IllegalArgumentException() instead of exception, normally the issue of the
                    same code block should not appear with the implementation of logs or analytics.
                 */
                emit(Result.failure(java.lang.IllegalArgumentException()))
            }else{
                emit(Result.failure(exception))
            }

        }
    }
}