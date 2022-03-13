package com.example.mytruenorthtest.postList.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name= "page_id")
    var pageId: Long = 0,

    @ColumnInfo(name = "author_fullname")
    var author: String? = "",

    @ColumnInfo(name = "created")
    var created: Double? = 0.0,

    @ColumnInfo(name = "thumbnail")
    var thumbnail: String? = "",

    @ColumnInfo(name = "num_comments")
    var numberComments: Int? = 0,

    @ColumnInfo(name = "new")
    var new: Boolean? = true
)
