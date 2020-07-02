package com.spiraldev.cryptoticker.core.di.modules

import android.app.Application
import android.content.Context
import com.spiraldev.cryptoticker.data.local.prefs.PreferenceStorage
import com.spiraldev.cryptoticker.data.local.prefs.SharedPreferenceStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule{

    @Provides
    @Singleton
    fun provideContext(app : Application) : Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun providePreferenceStorage(context: Context): PreferenceStorage = SharedPreferenceStorage(context)
}