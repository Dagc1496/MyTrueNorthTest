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
class DeletePostUseCaseTest {

    private val postRepository = mock<IPostRepository>()
    private val deletePostUseCase = DeletePostUseCase(postRepository)

    @Test
    fun deletePostTest() = runBlockingTest {

        //Arrange
        val post = mock<Post>()

        //Act
        deletePostUseCase.invoke(post.title)

        //Assert
        verify(postRepository, times(1)).deletePost(post.title)
    }
}