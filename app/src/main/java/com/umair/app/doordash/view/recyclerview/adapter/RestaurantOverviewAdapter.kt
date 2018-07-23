package com.umair.app.doordash.view.recyclerview.adapter

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.umair.app.doordash.R
import com.umair.app.doordash.injection.modules.GlideApp
import com.umair.app.doordash.model.RestaurantOverview
import com.umair.app.doordash.view.recyclerview.adapter.RestaurantOverviewAdapter.ViewHolder
import kotlinx.android.synthetic.main.restaurant_view.view.restaurant_image
import kotlinx.android.synthetic.main.restaurant_view.view.restaurant_open_until
import kotlinx.android.synthetic.main.restaurant_view.view.restaurant_tags
import kotlinx.android.synthetic.main.restaurant_view.view.restaurant_title

class RestaurantOverviewAdapter(private val context: Context?, private var restaurants: List<RestaurantOverview>) : RecyclerView.Adapter<ViewHolder>() {
  private lateinit var listener: View.OnClickListener

  class ViewHolder(val view: ConstraintLayout) : RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_view, parent, false) as ConstraintLayout
    val viewHolder = ViewHolder(view)
    viewHolder.view.setOnClickListener(listener)
    return viewHolder
  }

  override fun getItemCount(): Int {
    return restaurants.size
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val restaurant = restaurants[position]
    holder.view.restaurant_title.text = restaurant.name
    holder.view.restaurant_tags.text = restaurant.stringifyTags()
    holder.view.restaurant_open_until.text = restaurant.getStatusText()
    context?.let {
      GlideApp.with(it).load(restaurant.coverImgUrl).into(holder.view.restaurant_image)
    }
  }

  fun takeData(data: List<RestaurantOverview>) {
    restaurants = data
    notifyDataSetChanged()
  }

  fun setOnClickListener(listener: View.OnClickListener) {
    this.listener = listener
  }
}