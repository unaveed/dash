package com.umair.app.doordash.injection.modules

import android.content.Context
import com.umair.app.doordash.DashApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: DashApplication) {
    @Provides @Singleton fun providesContext() : Context = app

    @Provides @Singleton fun providesApplication() : DashApplication = app
}