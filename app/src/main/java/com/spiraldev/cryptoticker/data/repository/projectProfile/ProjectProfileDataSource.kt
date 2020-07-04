package com.spiraldev.cryptoticker.data.repository.projectProfile

import com.spiraldev.cryptoticker.data.local.database.CoinsDatabase
import javax.inject.Inject

class ProjectProfileDataSource @Inject constructor(private val db: CoinsDatabase){

    fun projectBySymbol(symbol: String) = db.coinsListDao().projectLiveDataFromSymbol(symbol)

}