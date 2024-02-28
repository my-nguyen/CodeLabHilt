package com.nguyen.codelabhilt.di

import android.content.Context
import androidx.room.Room
import com.nguyen.codelabhilt.data.AppDatabase
import com.nguyen.codelabhilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "logging.db").build()

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao = database.logDao()
}