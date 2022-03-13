package com.example.mytruenorthtest.di.module

import com.example.mytruenorthtest.BuildConfig
import com.example.mytruenorthtest.postList.data.remote.network.TopApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideUrlShortenerApiClient(retrofit: Retrofit): TopApiClient {
        return retrofit.create(TopApiClient::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}