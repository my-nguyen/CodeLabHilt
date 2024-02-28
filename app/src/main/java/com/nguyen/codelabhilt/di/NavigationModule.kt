package com.nguyen.codelabhilt.di

import com.nguyen.codelabhilt.navigator.AppNavigator
import com.nguyen.codelabhilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}