package com.nguyen.codelabhilt.di

import com.nguyen.codelabhilt.data.LoggerDataSource
import com.nguyen.codelabhilt.data.LoggerInMemoryDataSource
import com.nguyen.codelabhilt.data.LoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggingDatabaseModule {
    @Singleton
    @DatabaseLogger
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource
}

@Module
@InstallIn(ActivityComponent::class)
abstract class LoggingInMemoryModule {
    @ActivityScoped
    @InMemoryLogger
    @Binds
    abstract fun bindInMemoryLogger(impl: LoggerInMemoryDataSource): LoggerDataSource
}

@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger