package com.example.mytruenorthtest.postList.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PageResponse(
    @SerializedName("data") val top: TopResponse?
)
