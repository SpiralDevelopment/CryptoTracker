package com.spiraldev.cryptoticker.data.repository.projectProfile

import com.spiraldev.cryptoticker.api.ApiInterface
import com.spiraldev.cryptoticker.api.BaseRemoteDataSource
import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result
import com.spiraldev.cryptoticker.api.models.HistoricalPriceResponse

class ProjectProfileRemoteDataSource @Inject constructor(private val service: ApiInterface) : BaseRemoteDataSource(){

    //fetch historical price from backend
    suspend fun historicalPrice(symbol: String, targetCurrency: String, days: Int = 30): Result<HistoricalPriceResponse> =
        getResult { service.historicalPrice(symbol, targetCurrency, days) }

}