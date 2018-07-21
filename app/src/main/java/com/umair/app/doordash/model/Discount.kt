package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class Discount(
        @SerializedName("description") val description: String = "",
        @SerializedName("source_type") val sourceType: String = "",
        @SerializedName("text") val text: String = "",
        @SerializedName("discount_type") val discountType: String = "",
        @SerializedName("amount") val amount: Amount = Amount(),
        @SerializedName("min_subtotal") val minSubtotal: MinSubtotal = MinSubtotal()
)