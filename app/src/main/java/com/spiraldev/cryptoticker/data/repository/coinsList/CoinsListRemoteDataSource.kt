package com.spiraldev.cryptoticker.data.repository.coinsList

import com.spiraldev.cryptoticker.api.ApiInterface
import com.spiraldev.cryptoticker.api.BaseRemoteDataSource
import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result
import com.spiraldev.cryptoticker.api.models.Coin

class CoinsListRemoteDataSource @Inject constructor(private val service: ApiInterface) :
    BaseRemoteDataSource() {

    suspend fun coinsList(targetCur: String): Result<List<Coin>> =
        getResult {
            service.coinsList(targetCur)
        }
}