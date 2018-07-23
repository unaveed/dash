package com.umair.app.doordash.injection.modules

import com.umair.app.doordash.datasource.network.NetworkService
import com.umair.app.doordash.viewmodel.RestaurantViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModules {
  @Provides @Singleton fun providesRestaurantViewModel(networkService: NetworkService) : RestaurantViewModel {
    return RestaurantViewModel(networkService)
  }
}
