package com.spiraldev.cryptoticker.data.repository.coinsList

import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result
import com.spiraldev.cryptoticker.api.models.Coin

class CoinsListRepository @Inject constructor(private val coinsListRemoteDataSource: CoinsListRemoteDataSource) {

    suspend fun coinsList(targetCur: String): Result<List<Coin>> = coinsListRemoteDataSource.coinsList(targetCur)
}