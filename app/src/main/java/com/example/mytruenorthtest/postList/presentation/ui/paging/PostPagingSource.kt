package com.example.mytruenorthtest.postList.presentation.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.useCase.TopUseCase
import javax.inject.Inject

class PostPagingSource @Inject constructor(private val topUseCase: TopUseCase) :
    PagingSource<String, Post>(){

    override fun getRefreshKey(state: PagingState<String, Post>): String? = null

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Post> {
        val page = params.key

        topUseCase.invoke(page).fold(
            onSuccess = {
                val postList = it.postList

                val nextPage: String? = it.after

                return LoadResult.Page(
                    data = postList,
                    prevKey = it.before,
                    nextKey = nextPage
                )
            },
            onFailure = {   exception ->
                return LoadResult.Error(exception)
            })
    }
}