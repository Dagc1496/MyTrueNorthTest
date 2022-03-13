package com.example.mytruenorthtest.postList.domain.repository

import com.example.mytruenorthtest.postList.domain.model.Page

interface IPageRepository {

    suspend fun fetchTopPage(after: String? = null) : Page

    suspend fun refreshTop(): Page

}