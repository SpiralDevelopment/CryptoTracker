package com.spiraldev.cryptoticker.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CoinsListDao {

    //Returns all stocks
    @Query("Select * from coins_list")
    fun coinsList(): LiveData<List<CoinsListEntity>>

    //Returns stocks based on symbol
    @Query("Select * from coins_list where symbol = :symbol")
    suspend fun projectFromSymbol(symbol: String): CoinsListEntity?

    //Returns stocks livedata based on symbol
    @Query("Select * from coins_list where symbol = :symbol")
    fun projectLiveDataFromSymbol(symbol: String): LiveData<CoinsListEntity>

    //Retruns all favourite stocks
    @Query("Select * from coins_list where isFavourite = 1")
    fun favouriteCoins(): LiveData<List<CoinsListEntity>>

    //Returns all favourite symbols
    @Query("Select symbol from coins_list where isFavourite = 1")
    suspend fun favouriteSymbols(): List<String>

    //Inserts data. If row already exists, replace the row
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stockList: List<CoinsListEntity>)

    //Update the row
    @Update
    suspend fun updateCoinsListEntity(data: CoinsListEntity): Int

    //Delete all rows
    @Query("Delete from coins_list")
    suspend fun deleteAll()

}