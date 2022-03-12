package com.example.mytruenorthtest.postList.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class PostEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "author_fullname")
    val author: String?,

    @ColumnInfo(name = "created")
    val created: Double?,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String?,

    @ColumnInfo(name = "num_comments")
    val numberComments: Int?,

    @ColumnInfo(name = "new")
    val new: Boolean?
)
