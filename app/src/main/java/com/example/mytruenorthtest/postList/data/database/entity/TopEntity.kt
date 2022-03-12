package com.example.mytruenorthtest.postList.data.database.entity


import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "top_table")
data class TopEntity(
    @Embedded
    val top: PageEntity
)
