package com.umair.app.doordash

import android.app.Application
import com.umair.app.doordash.injection.components.AppComponent
import com.umair.app.doordash.injection.components.DaggerAppComponent

class DashApplication : Application() {

  companion object {
    lateinit var appComponent: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder().build()
    appComponent.inject(this)
  }

  fun getAppComponent(): AppComponent = appComponent
}