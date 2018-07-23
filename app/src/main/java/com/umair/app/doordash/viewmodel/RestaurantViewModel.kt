package com.umair.app.doordash.viewmodel

import com.umair.app.doordash.datasource.network.NetworkService
import com.umair.app.doordash.model.RestaurantOverview
import io.reactivex.subjects.BehaviorSubject


class RestaurantViewModel(private val networkService: NetworkService) {

  val restaurantsData = BehaviorSubject.create<List<RestaurantOverview>>()
  val loadingRestaurants = BehaviorSubject.create<Boolean>()

  fun getRestaurants(latitude: Double, longitude: Double) {
    loadingRestaurants.onNext(true)
    networkService.getRestaurants(latitude, longitude)
        .subscribe { list ->
          run {
            loadingRestaurants.onNext(false)
            list?.let {
              restaurantsData.onNext(list)
            }
          }
        }
//        .map { list -> restaurantsData.onNext(list) }
//        .map { loadingRestaurants.onNext(false) }
//        .subscribe()
  }
}
