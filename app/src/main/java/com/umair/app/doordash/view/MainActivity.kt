package com.umair.app.doordash.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.umair.app.doordash.R
import com.umair.app.doordash.view.Pages.RESTAURANTS
import com.umair.app.doordash.view.fragments.RestaurantsFragment

class MainActivity : AppCompatActivity() {
  companion object {
    const val BACK_STACK_TAG = "root_back_stack_tag"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    changeView(RESTAURANTS)
  }

  fun changeView(page: Pages) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    when (page) {
      Pages.RESTAURANTS -> {
        fragmentTransaction
            .add(R.id.main_activity, RestaurantsFragment())
            .addToBackStack(BACK_STACK_TAG)
            .commit()
      }
    }
  }
}
