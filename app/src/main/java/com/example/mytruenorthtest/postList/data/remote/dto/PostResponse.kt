package com.example.mytruenorthtest.postList.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("data") val postInformation: PostInformationResponse?
)