package com.umair.app.doordash.view.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.umair.app.doordash.model.RestaurantOverview
import com.umair.app.doordash.view.recyclerview.viewholder.RestaurantOverviewViewHolder

class RestaurantOverviewAdapter(private val restaurantOverviewList : List<RestaurantOverview>) : RecyclerView.Adapter<RestaurantOverviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantOverviewViewHolder {
        TODO()
    }

    override fun getItemCount(): Int {
        return restaurantOverviewList.size
    }

    override fun onBindViewHolder(holder: RestaurantOverviewViewHolder, position: Int) {
        TODO()
    }
}