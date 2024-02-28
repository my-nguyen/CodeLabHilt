package com.nguyen.codelabhilt

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.nguyen.codelabhilt.data.AppDatabase
import com.nguyen.codelabhilt.data.LoggerLocalDataSource
import com.nguyen.codelabhilt.navigator.AppNavigator
import com.nguyen.codelabhilt.navigator.AppNavigatorImpl
import com.nguyen.codelabhilt.util.DateFormatter

class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())

    fun provideDateFormatter() = DateFormatter()

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}
