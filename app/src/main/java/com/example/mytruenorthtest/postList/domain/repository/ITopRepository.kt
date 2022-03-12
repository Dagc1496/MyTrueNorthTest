package com.example.mytruenorthtest.postList.domain.repository

import com.example.mytruenorthtest.postList.domain.model.Top

interface ITopRepository {

    fun fetchTop() : Top

    fun fetchTopNextPage(after: String) : Top

}