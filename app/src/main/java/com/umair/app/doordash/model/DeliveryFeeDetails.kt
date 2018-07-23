package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class DeliveryFeeDetails(
    @SerializedName("final_fee") val finalFee: FinalFee = FinalFee(),
    @SerializedName("discount") val discount: Discount = Discount(),
    @SerializedName("surge_fee") val surgeFee: SurgeFee = SurgeFee(),
    @SerializedName("original_fee") val originalFee: OriginalFee = OriginalFee()
)