package com.umair.app.doordash.model

import org.junit.Assert
import org.junit.Test


class RestaurantOverviewTest {
  @Test
  fun stringifyTagsEmpty() {
    val restaurant = RestaurantOverview(tags = arrayListOf())
    val expected = ""

    Assert.assertEquals(expected, restaurant.stringifyTags())
  }

  @Test
  fun stringifyTagsNotEmpty() {
    val tags = arrayListOf("Chinese", "Asian Fusion", "Fast Food")
    val restaurant = RestaurantOverview(tags = tags)
    val expected = "Chinese, Asian Fusion, Fast Food"

    Assert.assertEquals(expected, restaurant.stringifyTags())
  }

  @Test
  fun getStatusTextWhenStatusTypeIsOpen() {
    val expected = "24 mins"
    val restaurant = RestaurantOverview(statusType = "open", status = expected)

    Assert.assertEquals(expected, restaurant.getStatusText())
  }

  @Test
  fun getStatusTextWhenStatusTypeIsPreOrder() {
    val expected = "Pre-order"
    val restaurant = RestaurantOverview(statusType = "pre-order", status = "Pre-order for Pre-order")

    Assert.assertEquals(expected, restaurant.getStatusText())
  }
}
