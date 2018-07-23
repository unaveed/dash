package com.umair.app.doordash.datasource.network.api

import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.DELIMITER
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.ENDPOINT_RESTAURANT
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.ENDPOINT_VERSION
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.QUERY_LATITUDE
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.QUERY_LIMIT
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.QUERY_LONGITUDE
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.QUERY_OFFSET
import com.umair.app.doordash.model.Restaurant
import com.umair.app.doordash.model.RestaurantOverview
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantAPIService {
    @GET("$DELIMITER$ENDPOINT_VERSION$DELIMITER$ENDPOINT_RESTAURANT$DELIMITER") fun getRestaurants(
            @Query(QUERY_LATITUDE) latitude: Double,
            @Query(QUERY_LONGITUDE) longitude: Double,
            @Query(QUERY_OFFSET) offset: Int,
            @Query(QUERY_LIMIT) limit: Int
    ): Observable<List<RestaurantOverview>>

    @GET("$DELIMITER$ENDPOINT_VERSION$DELIMITER$ENDPOINT_RESTAURANT$DELIMITER{restaurant_id}$DELIMITER") fun getRestaurant(
            @Path("restaurant_id") restaurantId : Int
    ): Observable<Restaurant>
}