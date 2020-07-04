package com.spiraldev.cryptoticker.api.models



data class HistoricalPriceResponse(
    val prices: List<DoubleArray>
)