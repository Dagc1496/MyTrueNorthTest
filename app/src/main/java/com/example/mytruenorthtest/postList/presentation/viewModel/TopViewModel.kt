package com.example.mytruenorthtest.postList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.useCase.TopUseCase
import com.example.mytruenorthtest.postList.presentation.constant.PagingConstants
import com.example.mytruenorthtest.postList.presentation.ui.paging.PostPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    private val topUseCase: TopUseCase,
) : ViewModel(){

    fun fetchTopPage(): Flow<PagingData<Post>> {
        val result = Pager(
            config = PagingConfig(pageSize = PagingConstants.NumberOfItems, maxSize = PagingConstants.MaxNumberOfItems),
            pagingSourceFactory = { PostPagingSource(topUseCase) }
        ).flow.cachedIn(viewModelScope)
        return result
    }
}