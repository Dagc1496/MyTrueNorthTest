package com.example.mytruenorthtest.di.module

import com.example.mytruenorthtest.BuildConfig
import com.example.mytruenorthtest.postList.data.remote.network.PostsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideUrlShortenerApiClient(retrofit: Retrofit): PostsApiClient {
        return retrofit.create(PostsApiClient::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}