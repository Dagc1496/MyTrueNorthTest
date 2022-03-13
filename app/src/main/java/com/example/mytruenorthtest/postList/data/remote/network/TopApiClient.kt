package com.example.mytruenorthtest.postList.data.remote.network

import com.example.mytruenorthtest.postList.data.remote.dto.TopResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface TopApiClient {

    @POST("/top.json")
    suspend fun fetchTop(): TopResponse

    @POST("/top.json")
    suspend fun fetchTopNextPage(@Query("after")after: String? = null): TopResponse

}