package com.nguyen.codelabhilt.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.codelabhilt.LogApplication
import com.nguyen.codelabhilt.R
import com.nguyen.codelabhilt.navigator.AppNavigator
import com.nguyen.codelabhilt.navigator.Screens

/**
 * Main activity of the application.
 *
 * Container for the Buttons & Logs fragments. This activity simply tracks clicks on buttons.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = (applicationContext as LogApplication).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
