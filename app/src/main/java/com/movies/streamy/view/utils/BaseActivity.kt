package com.movies.streamy.view.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.movies.streamy.utils.Prefs


open class BaseActivity : AppCompatActivity() {

    private lateinit var prefs: Prefs
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { updateLocale(it) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateLocale()
    }

    private fun updateLocale(newBase: Context): Context? {

        var newBase = newBase

        val config = Configuration(newBase.resources?.configuration)

        newBase = newBase.createConfigurationContext(config)
        newBase.resources?.updateConfiguration(config, newBase.resources.displayMetrics)
        return newBase
    }

    private fun updateLocale() {
        val resources: Resources = resources
        val config: Configuration = resources.configuration

        resources.updateConfiguration(config, resources.displayMetrics)
    }
}