package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class Menu(
        @SerializedName("status") val status: String = "",
        @SerializedName("menu_version") val menuVersion: Int = 0,
        @SerializedName("subtitle") val subtitle: String = "",
        @SerializedName("name") val name: String = "",
        @SerializedName("open_hours") val openHours: List<List<OpenHour>> = listOf(),
        @SerializedName("is_business_enabled") val isBusinessEnabled: Boolean,
        @SerializedName("is_catering") val isCatering: Boolean = false,
        @SerializedName("id") val id: Int = 0,
        @SerializedName("status_type") val statusType: String = ""
)