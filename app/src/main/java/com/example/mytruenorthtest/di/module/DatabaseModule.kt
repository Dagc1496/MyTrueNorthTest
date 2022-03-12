package com.example.mytruenorthtest.di.module

import android.content.Context
import androidx.room.Room
import com.example.mytruenorthtest.postList.data.database.TopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object DatabaseModule {

    private val TOP_DATABASE_NAME = "top_database"

    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TopDatabase::class.java, TOP_DATABASE_NAME).build()

    @Provides
    fun provideUrlShortenedDao(database: TopDatabase) = database.getTopDao()
}