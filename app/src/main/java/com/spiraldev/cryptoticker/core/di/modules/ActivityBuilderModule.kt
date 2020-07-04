package com.spiraldev.cryptoticker.core.di.modules

import com.spiraldev.cryptoticker.core.di.annotations.ActivityScope
import com.spiraldev.cryptoticker.ui.home.HomeActivity
import com.spiraldev.cryptoticker.ui.home.HomeActivityModule
import com.spiraldev.cryptoticker.ui.home.coinsList.CoinListModule
import com.spiraldev.cryptoticker.ui.home.favoruites.FavouritesModule
import com.spiraldev.cryptoticker.ui.projectProfile.ProjectProfileActivity
import com.spiraldev.cryptoticker.ui.projectProfile.ProjectProfileModule
import com.spiraldev.cryptoticker.ui.home.settings.SettingsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [HomeActivityModule::class,
            CoinListModule::class,
            FavouritesModule::class,
            SettingsModule::class]
    )
    abstract fun HomeActivity(): HomeActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ProjectProfileModule::class])
    abstract fun ProjectProfileActivity(): ProjectProfileActivity
}
