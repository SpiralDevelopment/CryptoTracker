package com.spiraldev.cryptoticker.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.spiraldev.cryptoticker.data.local.database.DB.DATABASE_NAME
import com.spiraldev.cryptoticker.data.local.database.DB.DATABASE_VERSION


@Database(entities = [CoinsListEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class CoinsDatabase : RoomDatabase() {

    abstract fun coinsListDao(): CoinsListDao

    companion object {
        fun buildDatabase(context: Context): CoinsDatabase {
            return Room.databaseBuilder(context, CoinsDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}