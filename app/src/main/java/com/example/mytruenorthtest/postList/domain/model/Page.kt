package com.example.mytruenorthtest.postList.domain.model

data class Page(
    val after: String?,
    val before: String?,
    val postList: List<Post>
)
