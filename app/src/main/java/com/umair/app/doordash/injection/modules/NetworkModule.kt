package com.umair.app.doordash.injection.modules

import android.content.Context
import com.bumptech.glide.Glide
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.BASE_URL
import com.umair.app.doordash.datasource.network.NetworkConstants.Companion.DEFAULT_TIMEOUT
import com.umair.app.doordash.datasource.network.NetworkService
import com.umair.app.doordash.datasource.network.api.RestaurantAPIService
import com.umair.app.doordash.datasource.network.schedulers.RxSchedulerProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module
class NetworkModule {
  @Provides
  fun providesGson(): Gson {
    return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
  }

  @Provides
  internal fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = BASIC
    return interceptor
  }

  @Provides
  fun providesOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(DEFAULT_TIMEOUT, SECONDS)
        .writeTimeout(DEFAULT_TIMEOUT, SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
  }

  @Provides
  @Singleton
  fun providesRestaurantAPIService(okHttpClient: OkHttpClient, gson: Gson): RestaurantAPIService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(RestaurantAPIService::class.java)
  }

  @Provides
  @Singleton
  fun providesRxSchedulerProvider(): RxSchedulerProvider = RxSchedulerProvider()

  @Provides
  @Singleton
  fun providesNetworkService(restaurantAPIService: RestaurantAPIService, rxSchedulerProvider: RxSchedulerProvider): NetworkService {
    return NetworkService(restaurantAPIService, rxSchedulerProvider)
  }
}