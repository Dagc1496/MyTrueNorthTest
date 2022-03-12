package com.example.mytruenorthtest.postList.data.database.entity

import androidx.room.ColumnInfo

data class PostStateEntity(
    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "new")
    val new: Boolean?
)
