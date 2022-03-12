package com.example.mytruenorthtest.postList.data.remote.network

import com.example.mytruenorthtest.postList.data.remote.dto.PostResponse
import retrofit2.http.POST

interface PostsApiClient {

    @POST("/top.json")
    suspend fun fetchUrlShorted(): PostResponse

}