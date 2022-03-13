package com.example.mytruenorthtest.postList.data.implementation

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.data.database.dao.PageDao
import com.example.mytruenorthtest.postList.data.database.dao.PostDao
import com.example.mytruenorthtest.postList.data.database.entity.PageEntity
import com.example.mytruenorthtest.postList.data.database.entity.PostEntity
import com.example.mytruenorthtest.postList.data.mapToDomain
import com.example.mytruenorthtest.postList.data.mapToEntity
import com.example.mytruenorthtest.postList.data.remote.dto.PostResponse
import com.example.mytruenorthtest.postList.data.remote.dto.TopResponse
import com.example.mytruenorthtest.postList.data.remote.network.TopApiClient
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.repository.IPageRepository
import javax.inject.Inject

class PageRepository @Inject constructor(
    private val apiClient: TopApiClient,
    private val pageDao: PageDao,
    private val postDao: PostDao
) : IPageRepository {

    override suspend fun fetchTopPage(after: String?) : Page {
        val response: TopResponse = apiClient.fetchTopNextPage(after)
        val pageEntity:PageEntity = response.top?.mapToEntity() ?: throw NoDataRecivedException()
        val postEntities:List<PostEntity> = proccessPostResponse(response.top.postList)
        pageDao.insertPage(pageEntity)
        postEntities.forEach { postDao.insertPost(it) }

        return pageEntity.mapToDomain(postEntities)
    }

    override suspend fun refreshTop(): Page {
        pageDao.deleteAll()
        return fetchTopPage()
    }

    private fun proccessPostResponse(postResponse: List<PostResponse>) : List<PostEntity>{
        return postResponse.map {
            it.mapToEntity()
        }
    }
}