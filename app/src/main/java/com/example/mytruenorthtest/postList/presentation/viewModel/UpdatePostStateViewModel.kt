package com.example.mytruenorthtest.postList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.useCase.UpdatePostStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdatePostStateViewModel @Inject constructor(
    private val updatePostStateUseCase: UpdatePostStateUseCase,
) : ViewModel(){

    fun updatePostState(post: Post) {
        viewModelScope.launch {
            updatePostStateUseCase.invoke(post)
        }
    }
}