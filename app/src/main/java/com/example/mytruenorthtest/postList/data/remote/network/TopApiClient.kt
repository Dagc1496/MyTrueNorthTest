package com.example.mytruenorthtest.postList.data.remote.network

import com.example.mytruenorthtest.postList.data.remote.dto.TopResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TopApiClient {

    @GET("/top.json")
    suspend fun fetchTopNextPage(@Query("after")after: String? = null): TopResponse

}