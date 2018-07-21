package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class OverviewMenu(
        @SerializedName("popular_items") val popularItems: List<PopularItem> = listOf(),
        @SerializedName("is_catering") val isCatering: Boolean = false,
        @SerializedName("subtitle") val subtitle: String = "",
        @SerializedName("id") val id: Int = 0,
        @SerializedName("name") val name: String = ""
)