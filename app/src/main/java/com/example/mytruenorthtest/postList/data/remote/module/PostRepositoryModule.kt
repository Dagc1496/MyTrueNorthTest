package com.example.mytruenorthtest.postList.data.remote.module

import com.example.mytruenorthtest.postList.data.implementation.PostRepository
import com.example.mytruenorthtest.postList.domain.repository.IPostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PostRepositoryModule {

    @Binds
    abstract fun bindDomainRepository(
        urlShortenerRepository: PostRepository
    ): IPostRepository

}