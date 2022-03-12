package com.example.mytruenorthtest.postList.data

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.data.database.entity.PageEntity
import com.example.mytruenorthtest.postList.data.database.entity.PostEntity
import com.example.mytruenorthtest.postList.data.database.entity.TopEntity
import com.example.mytruenorthtest.postList.data.remote.dto.PageResponse
import com.example.mytruenorthtest.postList.data.remote.dto.PostResponse
import com.example.mytruenorthtest.postList.data.remote.dto.TopResponse
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.model.Post
import com.example.mytruenorthtest.postList.domain.model.Top

fun TopResponse.mapToEntity(): TopEntity =
    TopEntity(
        top = top?.mapToEntity() ?: throw NoDataRecivedException(),
    )

fun PageResponse.mapToEntity(): PageEntity =
    PageEntity(
        after = after,
        before = before,
        post = postList?.mapToEntity() ?: throw NoDataRecivedException()
    )

fun PostResponse.mapToEntity(): PostEntity =
    PostEntity(
        title = title ?: throw NoDataRecivedException(),
        author = author ?: throw NoDataRecivedException(),
        created = created ?: throw NoDataRecivedException(),
        thumbnail = thumbnail ?: throw NoDataRecivedException(),
        numberComments = numberComments ?: throw NoDataRecivedException()
    )

fun TopEntity.mapToDomain(): Top =
    Top(
        top = top.mapToDomain()
    )

fun PageEntity.mapToDomain(): Page =
    Page(
        after = after,
        before = before,
        post = post.mapToDomain()
    )

fun PostEntity.mapToDomain(): Post =
    Post(
        title = title ?: throw NoDataRecivedException(),
        author = author ?: throw NoDataRecivedException(),
        created = created ?: throw NoDataRecivedException(),
        thumbnail = thumbnail ?: throw NoDataRecivedException(),
        numberComments = numberComments ?: throw NoDataRecivedException(),
        new = true
    )