package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class PopularItem(
        @SerializedName("price") val price: Int = 0,
        @SerializedName("description") val description: String = "",
        @SerializedName("img_url") val imgUrl: String = "",
        @SerializedName("id") val id: Int = 0,
        @SerializedName("name") val name: String = ""
)