package com.example.mytruenorthtest.postList.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TopResponse(
    @SerializedName("data") val top: PageResponse?
)
