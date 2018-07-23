package com.umair.app.doordash.view.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.umair.app.doordash.DashApplication
import com.umair.app.doordash.R
import com.umair.app.doordash.model.RestaurantOverview
import com.umair.app.doordash.view.recyclerview.adapter.RestaurantOverviewAdapter
import com.umair.app.doordash.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_restaurants.restaurants_loading_text
import kotlinx.android.synthetic.main.fragment_restaurants.restaurants_recycler_view
import javax.inject.Inject

class RestaurantsFragment : Fragment() {
  private lateinit var recyclerView: RecyclerView
  private lateinit var viewAdapter: RestaurantOverviewAdapter
  private lateinit var viewManager: RecyclerView.LayoutManager

  @Inject
  lateinit var viewModel: RestaurantViewModel

  companion object {
    const val TAG = "RestaurantsFragment"
    const val TITLE = "Discover"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    DashApplication.appComponent.inject(this)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_restaurants, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    activity?.title = TITLE
    val restaurantList = ArrayList<RestaurantOverview>()
    viewManager = LinearLayoutManager(activity)
    viewAdapter = RestaurantOverviewAdapter(activity, restaurantList)
    viewAdapter.setOnClickListener(View.OnClickListener { v -> Log.d(TAG, "Clicked on item # " + restaurants_recycler_view.indexOfChild(v)) })
    recyclerView = restaurants_recycler_view.apply {
      layoutManager = viewManager
      adapter = viewAdapter
    }

    viewModel.loadingRestaurants.subscribe { isLoading -> setLoadingVisible(isLoading) }
    viewModel.restaurantsData.subscribe { restaurants -> viewAdapter.takeData(restaurants) }
    viewModel.getRestaurants(37.422740, -122.139956)
  }

  private fun setLoadingVisible(isLoading: Boolean?) {
    isLoading?.let {
      if (!it) {
        recyclerView.visibility = VISIBLE
        restaurants_loading_text.visibility = GONE
      } else {
        recyclerView.visibility = INVISIBLE
        restaurants_loading_text.visibility = VISIBLE
      }
    }
  }
}
