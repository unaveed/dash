package com.umair.app.doordash.viewmodel

import com.umair.app.doordash.datasource.network.NetworkService
import com.umair.app.doordash.datasource.network.api.RestaurantAPIService
import com.umair.app.doordash.datasource.network.schedulers.SchedulerProvider
import com.umair.app.doordash.model.RestaurantOverview
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyDouble
import org.mockito.Mockito.reset
import org.mockito.MockitoAnnotations.initMocks
import java.util.Random

class RestaurantViewModelTest {
  private lateinit var viewModel: RestaurantViewModel
  private lateinit var networkService: NetworkService
  private lateinit var testScheduler: TestScheduler
  private val random = Random()

  @Mock private lateinit var schedulerProvider: SchedulerProvider
  @Mock private lateinit var restaurantAPIService: RestaurantAPIService

  @Before
  fun setUp() {
    initMocks(this)
    testScheduler = TestScheduler()
    `when`(schedulerProvider.getUIScheduler()).thenReturn(testScheduler)
    `when`(schedulerProvider.getIOScheduler()).thenReturn(testScheduler)
    networkService = NetworkService(restaurantAPIService, schedulerProvider)
    viewModel = RestaurantViewModel(networkService)
  }

  @After
  fun tearDown() {
    reset(schedulerProvider, restaurantAPIService)
  }

  private fun createRestaurantsList(size: Int) : List<RestaurantOverview> {
    val list = mutableListOf<RestaurantOverview>()
    for (i in 1..size) {
      list.add(RestaurantOverview())
    }
    return list.toList()
  }

  @Test
  fun testGetRestaurants() {
    val observable = Observable.fromArray(createRestaurantsList(10))
    val testObserver = TestObserver<List<RestaurantOverview>>()
    `when`(restaurantAPIService.getRestaurants(anyDouble(), anyDouble(), anyInt(), anyInt())).thenReturn(observable)

    viewModel.getRestaurants(random.nextDouble(), random.nextDouble())
    viewModel.restaurantsData.subscribe(testObserver)
    testScheduler.triggerActions()

    testObserver.assertValueCount(1)
    testObserver.assertValue { list -> list.size == 10 }
  }

  @Test
  fun testGetRestaurantsCorrectLoadingStatus() {
    val observable = Observable.fromArray(createRestaurantsList(4))

    val testDataObserver = TestObserver<List<RestaurantOverview>>()
    val testLoadingObserver = TestObserver<Boolean>()
    `when`(restaurantAPIService.getRestaurants(anyDouble(), anyDouble(), anyInt(), anyInt())).thenReturn(observable)

    viewModel.getRestaurants(random.nextDouble(), random.nextDouble())
    viewModel.loadingRestaurants.subscribe(testLoadingObserver)

    viewModel.restaurantsData.subscribe(testDataObserver)
    testScheduler.triggerActions()

    testDataObserver.assertValueCount(1)
    testDataObserver.assertValue { list -> list.size == 4 }

    testLoadingObserver.assertValueCount(2)
    testLoadingObserver.assertValueAt(0, true)
    testLoadingObserver.assertValueAt(1, false)
  }
}
