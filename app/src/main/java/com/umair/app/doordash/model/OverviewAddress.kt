package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class OverviewAddress(
        @SerializedName("city") val city: String = "",
        @SerializedName("state") val state: String = "",
        @SerializedName("street") val street: String = "",
        @SerializedName("lat") val lat: Double = 0.0,
        @SerializedName("lng") val lng: Double = 0.0,
        @SerializedName("printable_address") val printableAddress: String = ""
)