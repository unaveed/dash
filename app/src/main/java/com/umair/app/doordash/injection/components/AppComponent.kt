package com.umair.app.doordash.injection.components

import com.umair.app.doordash.DashApplication
import com.umair.app.doordash.injection.modules.AppModule
import com.umair.app.doordash.injection.modules.NetworkModule
import com.umair.app.doordash.injection.modules.ViewModules
import com.umair.app.doordash.view.fragments.RestaurantsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (NetworkModule::class), (ViewModules::class)])
interface AppComponent {
  fun inject(dashApplication: DashApplication)
  fun inject(restaurantsFragment: RestaurantsFragment)
}