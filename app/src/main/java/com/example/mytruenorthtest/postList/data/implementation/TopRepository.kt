package com.example.mytruenorthtest.postList.data.implementation

import com.example.mytruenorthtest.postList.data.database.dao.TopDao
import com.example.mytruenorthtest.postList.data.mapToDomain
import com.example.mytruenorthtest.postList.data.mapToEntity
import com.example.mytruenorthtest.postList.data.remote.dto.TopResponse
import com.example.mytruenorthtest.postList.data.remote.network.PostsApiClient
import com.example.mytruenorthtest.postList.domain.model.Top
import com.example.mytruenorthtest.postList.domain.repository.ITopRepository
import javax.inject.Inject

class TopRepository @Inject constructor(
    private val apiClient: PostsApiClient,
    private val topDao: TopDao
) : ITopRepository {

    override suspend fun fetchTop() : Top{
        val response: TopResponse = apiClient.fetchTop()
        val topEntity = response.mapToEntity()
        topDao.insert(topEntity)
        return topEntity.mapToDomain()
    }

    override suspend fun fetchTopNextPage(after: String) : Top{
        val response:TopResponse = apiClient.fetchTopNextPage(after)
        val topEntity = response.mapToEntity()
        topDao.insert(topEntity)
        return topEntity.mapToDomain()
    }

    override suspend fun refreshTop(): Top {
        topDao.deleteAll()
        return fetchTop()
    }
}