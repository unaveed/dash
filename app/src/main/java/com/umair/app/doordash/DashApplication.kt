package com.umair.app.doordash

import android.app.Application
import com.umair.app.doordash.injection.components.DaggerAppComponent

class DashApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)
    }
}