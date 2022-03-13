package com.example.mytruenorthtest.postList.data

import com.example.mytruenorthtest.common.exception.NoDataRecivedException
import com.example.mytruenorthtest.postList.data.database.entity.PageEntity
import com.example.mytruenorthtest.postList.data.database.entity.PostEntity
import com.example.mytruenorthtest.postList.data.remote.dto.PageResponse
import com.example.mytruenorthtest.postList.data.remote.dto.PostResponse
import com.example.mytruenorthtest.postList.domain.model.Page
import com.example.mytruenorthtest.postList.domain.model.Post

fun PageResponse.mapToEntity(): PageEntity =
    PageEntity(
        after = after?.ifBlank { throw IllegalArgumentException() },
        before = before?.ifBlank { throw IllegalArgumentException() }
    )

fun PostResponse.mapToEntity(): PostEntity =
    PostEntity(
        title = postInformation?.title ?: throw NoDataRecivedException(),
        author = postInformation.author ?: throw NoDataRecivedException(),
        created = postInformation.created ?: throw NoDataRecivedException(),
        thumbnail = postInformation.thumbnail ?: throw NoDataRecivedException(),
        numberComments = postInformation.numberComments ?: throw NoDataRecivedException(),
        new = true
    )

fun PageEntity.mapToDomain(postEntities: List<PostEntity>): Page =
    Page(
        after = after?.ifBlank { throw IllegalArgumentException() },
        before = before?.ifBlank { throw IllegalArgumentException() },
        postList = postEntities.map { it.mapToDomain() }
    )

fun PostEntity.mapToDomain(): Post =
    Post(
        title = title,
        author = author ?: throw NoDataRecivedException(),
        created = created ?: throw NoDataRecivedException(),
        thumbnail = thumbnail ?: throw NoDataRecivedException(),
        numberComments = numberComments ?: throw NoDataRecivedException(),
        new = new ?: true
    )

fun Post.mapToEntity(): PostEntity =
    PostEntity(
        title = title,
        author = author,
        created = created,
        thumbnail = thumbnail,
        numberComments = numberComments,
        new = new
    )