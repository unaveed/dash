package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class OverviewBusiness(
        @SerializedName("id") val id: Int = 0,
        @SerializedName("name") val name: String = ""
)