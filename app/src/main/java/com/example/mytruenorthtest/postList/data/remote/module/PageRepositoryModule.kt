package com.example.mytruenorthtest.postList.data.remote.module

import com.example.mytruenorthtest.postList.data.implementation.PageRepository
import com.example.mytruenorthtest.postList.domain.repository.IPageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PageRepositoryModule {
    @Binds
    abstract fun bindDomainRepository(
        urlShortenerRepository: PageRepository
    ): IPageRepository
}