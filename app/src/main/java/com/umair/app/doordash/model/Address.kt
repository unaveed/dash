package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class Address(
        @SerializedName("city") val city: String = "",
        @SerializedName("subpremise") val subPremise: String = "",
        @SerializedName("id") val id: Int = 0,
        @SerializedName("printable_address") val printableAddress: String = "",
        @SerializedName("state") val state: String = "",
        @SerializedName("street") val street: String = "",
        @SerializedName("country") val country: String = "",
        @SerializedName("lat") val lat: Double = 0.0,
        @SerializedName("lng") val lng: Double = 0.0,
        @SerializedName("shortname") val shortName: String = "",
        @SerializedName("zip_code") val zipCode: String = ""
)