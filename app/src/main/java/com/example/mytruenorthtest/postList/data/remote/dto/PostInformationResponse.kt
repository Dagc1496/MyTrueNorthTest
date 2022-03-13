package com.example.mytruenorthtest.postList.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PostInformationResponse(
    @SerializedName("title") val title: String?,
    @SerializedName("author_fullname") val author: String?,
    @SerializedName("created") val created: Double?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("num_comments") val numberComments: Int?
)
