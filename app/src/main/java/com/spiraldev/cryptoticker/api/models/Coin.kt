package com.spiraldev.cryptoticker.api.models

import com.google.gson.annotations.SerializedName

data class Coin(
    val symbol: String?,
    val name: String?,
    @SerializedName("current_price") val price: Double?
)