package com.umair.app.doordash.injection.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.BASE_URL
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.DEFAULT_TIMEOUT
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.ENDPOINT_RESTAURANT
import com.umair.app.doordash.datasource.network.NetworkService
import com.umair.app.doordash.datasource.network.schedulers.RxSchedulerProvider
import com.umair.app.doordash.datasource.network.api.RestaurantAPIService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides fun providesGson() : Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
    }

    @Provides fun providesOkhttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(DEFAULT_TIMEOUT, SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, SECONDS)
                .build()
    }

    @Provides @Singleton fun providesRestaurantAPIService(okHttpClient: OkHttpClient, gson: Gson) : RestaurantAPIService {
        val retrofit =  Retrofit.Builder()
                .baseUrl(BASE_URL + ENDPOINT_RESTAURANT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
        return retrofit.create(RestaurantAPIService::class.java)
    }

    @Provides @Singleton fun providesRxSchedulerProvider() : RxSchedulerProvider = RxSchedulerProvider()

    @Provides @Singleton fun providesNetworkService(restaurantAPIService: RestaurantAPIService, rxSchedulerProvider: RxSchedulerProvider) : NetworkService {
        return NetworkService(restaurantAPIService, rxSchedulerProvider)
    }
}