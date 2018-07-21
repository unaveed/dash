package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class Amount(
        @SerializedName("display_string") val displayString: String = "",
        @SerializedName("unit_amount") val unitAmount: Int = 0
)