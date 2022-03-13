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
        title = title ?: throw NoDataRecivedException(),
        author = author ?: throw NoDataRecivedException(),
        created = created ?: throw NoDataRecivedException(),
        thumbnail = thumbnail ?: throw NoDataRecivedException(),
        numberComments = numberComments ?: throw NoDataRecivedException(),
        new = true
    )

fun PageEntity.mapToDomain(postEntities: List<PostEntity>): Page =
    Page(
        after = after?.ifBlank { throw IllegalArgumentException() },
        before = before?.ifBlank { throw IllegalArgumentException() },
        post = postEntities.map { it.mapToDomain() }
    )

fun PostEntity.mapToDomain(): Post =
    Post(
        title = title ?: throw NoDataRecivedException(),
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