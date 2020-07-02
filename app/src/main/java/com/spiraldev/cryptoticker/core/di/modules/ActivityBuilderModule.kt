package com.spiraldev.cryptoticker.core.di.modules

import com.spiraldev.cryptoticker.core.di.annotations.ActivityScope
import com.spiraldev.cryptoticker.ui.HomeActivity
import com.spiraldev.cryptoticker.ui.coinsList.CoinListModule
import com.spiraldev.cryptoticker.ui.favoruites.FavouritesModule
import com.spiraldev.cryptoticker.ui.settings.SettingsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [CoinListModule::class, FavouritesModule::class, SettingsModule::class])
    abstract fun HomeActivity(): HomeActivity
}
