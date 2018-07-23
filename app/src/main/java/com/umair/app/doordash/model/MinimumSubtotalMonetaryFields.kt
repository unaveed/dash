package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class MinimumSubtotalMonetaryFields(
    @SerializedName("currency") val currency: String = "",
    @SerializedName("display_string") val displayString: String = "",
    @SerializedName("unit_amount") val unitAmount: Int = 0,
    @SerializedName("decimal_places") val decimalPlaces: Int = 0
)
