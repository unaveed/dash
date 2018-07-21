package com.umair.app.doordash.datasource.network

import com.umair.app.doordash.datasource.network.api.RestaurantAPIService
import com.umair.app.doordash.datasource.network.schedulers.SchedulerProvider
import com.umair.app.doordash.model.Restaurant
import com.umair.app.doordash.model.RestaurantOverview
import io.reactivex.Observable

class NetworkService(private val restaurantAPIService: RestaurantAPIService, private val schedulerProvider: SchedulerProvider) {

    fun getRestaurants(latitude: Double, longitude: Double, offset: Int = 0, limit: Int = 50) : Observable<List<RestaurantOverview>> {
        return restaurantAPIService.getRestaurants(latitude, longitude, offset, limit)
                .observeOn(schedulerProvider.getUIScheduler())
                .subscribeOn(schedulerProvider.getIOScheduler())
    }

    fun getRestaurant(restaurantId: Int) : Observable<Restaurant> {
        return restaurantAPIService.getRestaurant(restaurantId)
                .observeOn(schedulerProvider.getUIScheduler())
                .subscribeOn(schedulerProvider.getIOScheduler())
    }
}