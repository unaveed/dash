package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class MerchantPromotion(
        @SerializedName("minimum_subtotal_monetary_fields") val minimumSubtotalMonetaryFields: MinimumSubtotalMonetaryFields,
        @SerializedName("delivery_fee") val deliveryFee: Int = 0,
        @SerializedName("delivery_fee_monetary_fields") val deliveryFeeMonetaryFields: DeliveryFeeMonetaryFields = DeliveryFeeMonetaryFields(),
        @SerializedName("minimum_subtotal") val minimumSubtotal: Int? = null,
        @SerializedName("new_store_customers_only") val newStoreCustomersOnly: Boolean = false,
        @SerializedName("id") val id: Int = 0
)