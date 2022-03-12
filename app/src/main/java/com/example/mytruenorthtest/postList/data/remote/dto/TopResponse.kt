package com.example.mytruenorthtest.postList.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TopResponse(
    @SerializedName("after") val after: String?,
    @SerializedName("before") val before: String?,
    @SerializedName("children") val postList: TopResponse?
)
