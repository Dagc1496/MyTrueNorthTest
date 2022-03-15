package com.example.mytruenorthtest.postList.domain.useCase

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.repository.IPageRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException

@ExperimentalCoroutinesApi
class TopUseCaseTest{

    private val pageRepository = mock<IPageRepository>()
    private val topUseCase = TopUseCase(pageRepository)

    @Test
    fun fetchTopPageSuccessTest() = runBlocking {

        //Arrange
        val pageMock = mock<Page>()
        val expected = Result.success(pageMock)
        whenever(pageRepository.fetchTopPage()).thenReturn(
            pageMock
        )

        //Act
        val result = topUseCase.invoke()

        assertEquals(expected, result)
    }
}