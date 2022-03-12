package com.example.mytruenorthtest.postList.domain.repository

import com.example.mytruenorthtest.postList.domain.model.Top

interface ITopRepository {

    suspend fun fetchTop() : Top

    suspend fun fetchTopNextPage(after: String) : Top

    suspend fun refreshTop(): Top

}