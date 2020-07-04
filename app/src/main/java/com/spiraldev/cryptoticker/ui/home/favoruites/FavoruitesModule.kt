package com.spiraldev.cryptoticker.ui.home.favoruites

import androidx.lifecycle.ViewModel
import com.spiraldev.cryptoticker.core.di.annotations.FragmentScope
import com.spiraldev.cryptoticker.core.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FavouritesModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeFavouritesFragment(): FavoritesFragment

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun bindFavouritesViewModel(viewModel: FavoritesViewModel): ViewModel
}