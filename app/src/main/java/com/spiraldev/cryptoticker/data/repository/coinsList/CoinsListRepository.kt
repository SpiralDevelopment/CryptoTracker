package com.spiraldev.cryptoticker.data.repository.coinsList

import javax.inject.Inject
import com.spiraldev.cryptoticker.api.Result
import com.spiraldev.cryptoticker.api.models.Coin
import com.spiraldev.cryptoticker.api.succeeded
import com.spiraldev.cryptoticker.data.local.database.CoinsListEntity
import com.spiraldev.cryptoticker.data.local.prefs.PreferenceStorage
import com.spiraldev.cryptoticker.util.Constants
import java.util.*
import java.util.concurrent.TimeUnit

class CoinsListRepository @Inject constructor(
    private val coinsListRemoteDataSource: CoinsListRemoteDataSource,
    private val coinsListDataSource: CoinsListDataSource,
    private val preferenceStorage: PreferenceStorage
) {
    val allCoinsLD = coinsListDataSource.allCoinsLD

    suspend fun coinsList(targetCur: String) {
        when (val result = coinsListRemoteDataSource.coinsList(targetCur)) {
            is Result.Success -> {
                if (result.succeeded) {
                    val favSymbols = coinsListDataSource.favouriteSymbols()

                    val customStockList = result.data.let {
                        it.filter { item -> item.symbol.isNullOrEmpty().not() }
                            .map { item ->
                                CoinsListEntity(
                                    item.symbol ?: "",
                                    item.id,
                                    item.name,
                                    item.price,
                                    item.changePercent,
                                    item.image,
                                    favSymbols.contains(item.symbol)
                                )
                            }
                    }

                    coinsListDataSource.insertCoinsIntoDB(customStockList)

                    preferenceStorage.timeLoadedAt = Date().time

                    Result.Success(true)
                } else {
                    Result.Error(Constants.GENERIC_ERROR)
                }
            }
            else -> result as Result.Error
        }
    }

    suspend fun updateFavouriteStatus(symbol: String): Result<CoinsListEntity> {
        val result = coinsListDataSource.updateFavouriteStatus(symbol)
        return result?.let {
            Result.Success(it)
        } ?: Result.Error(Constants.GENERIC_ERROR)
    }

    fun loadData(): Boolean {
        val lastLoadedDate = preferenceStorage.timeLoadedAt
        val currentDataMillis = Date().time
        return currentDataMillis - lastLoadedDate > 10 * 1000
    }
}