package com.example.mytruenorthtest.postList.domain.useCase

import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.repository.IPostRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

@ExperimentalCoroutinesApi
class UpdatePostStateUseCaseTest {

    private val postRepository = mock<IPostRepository>()
    private val updatePostStateUseCase = UpdatePostStateUseCase(postRepository)

    @Test
    fun updatePostStateTest() = runBlockingTest {

        //Arrange
        val post = mock<Post>()

        //Act
        updatePostStateUseCase.invoke(post)

        //Assert
        verify(postRepository, times(1)).updatePostState(post)
    }
}