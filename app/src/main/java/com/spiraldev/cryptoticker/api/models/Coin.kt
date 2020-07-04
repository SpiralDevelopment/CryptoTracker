package com.spiraldev.cryptoticker.api.models

import com.google.gson.annotations.SerializedName

data class Coin(
    val symbol: String?,
    val id: String?,
    val name: String?,
    val image: String?,
    @SerializedName("current_price") val price: Double?,
    @SerializedName("price_change_percentage_24h") val changePercent: Double?
)