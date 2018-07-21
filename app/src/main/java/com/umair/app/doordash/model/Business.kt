package com.umair.app.doordash.model
import com.google.gson.annotations.SerializedName

data class Business(
    @SerializedName("business_vertical") val businessVertical: Any? = Any(),
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = ""
)
