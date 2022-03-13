package com.example.mytruenorthtest.postList.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.useCase.TopUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TopViewModel @Inject constructor(
    private val topUseCase: TopUseCase,

) : ViewModel(){

    private val _loader = MutableStateFlow(false)
    val loader: StateFlow<Boolean> get() = _loader

    private val topPage = MutableLiveData<Result<Page>>()

    fun fetchTopPage(after: String? = null) = liveData {
        _loader.value = true
        emitSource(topUseCase.invoke(after).onEach {
            topPage.postValue(it)
            _loader.value = false
        }.asLiveData())
    }
}