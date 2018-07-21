package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName


data class OpenHour(
    @SerializedName("hour") private val hour: Long?,
    @SerializedName("minute") private val minute: Long?
)