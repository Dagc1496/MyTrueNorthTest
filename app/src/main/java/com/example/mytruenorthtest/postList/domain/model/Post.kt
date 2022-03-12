package com.example.mytruenorthtest.postList.domain.model

data class Post(
    val title: String,
    val author: String,
    val created: Double,
    val thumbnail: String,
    val numberComments: Int,
    var new: Boolean
)
