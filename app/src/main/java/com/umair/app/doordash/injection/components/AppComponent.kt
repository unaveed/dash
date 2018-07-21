package com.umair.app.doordash.injection.components

import com.umair.app.doordash.DashApplication
import com.umair.app.doordash.injection.modules.AppModule
import com.umair.app.doordash.injection.modules.NetworkModule
import dagger.Component

@Component(modules = [(AppModule::class), (NetworkModule::class)])
interface AppComponent {
    fun inject(dashApplication: DashApplication)
}