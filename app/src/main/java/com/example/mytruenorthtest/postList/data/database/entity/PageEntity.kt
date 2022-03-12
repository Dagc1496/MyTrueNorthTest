package com.example.mytruenorthtest.postList.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class PageEntity(
    @ColumnInfo(name = "after_post")
    var after: String = "",

    @ColumnInfo(name = "before_post")
    var before: String = "",

    @Embedded
    val post: PostEntity
)
