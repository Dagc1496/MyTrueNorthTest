package com.example.mytruenorthtest.postList.data.remote.network

import com.example.mytruenorthtest.postList.data.remote.dto.PostResponse
import com.example.mytruenorthtest.postList.data.remote.dto.TopResponse
import retrofit2.http.Header
import retrofit2.http.POST

interface PostsApiClient {

    @POST("/top.json")
    suspend fun fetchTop(): TopResponse

    @POST("/top.json")
    suspend fun fetchTopNextPage(@Header("after")after: String): TopResponse

}