package com.example.mytruenorthtest.postList.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "page_table")
data class PageEntity(
    @ColumnInfo(name = "after_post")
    var after: String? = "",

    @ColumnInfo(name = "before_post")
    var before: String? = "",
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "page_id")
    var pageId: Long = 0
}
