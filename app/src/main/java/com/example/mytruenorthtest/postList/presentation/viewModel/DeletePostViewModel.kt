package com.example.mytruenorthtest.postList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytruenorthtest.postList.domain.useCase.DeletePostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeletePostViewModel@Inject constructor(
    private val deletePostUseCase: DeletePostUseCase,
) : ViewModel(){

    fun deletePost(title: String) {
        viewModelScope.launch {
            deletePostUseCase.invoke(title)
        }
    }
}