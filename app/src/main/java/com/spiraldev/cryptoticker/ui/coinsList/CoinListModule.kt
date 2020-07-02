package com.spiraldev.cryptoticker.ui.coinsList

import androidx.lifecycle.ViewModel
import com.spiraldev.cryptoticker.core.di.annotations.FragmentScope
import com.spiraldev.cryptoticker.core.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class CoinListModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeCoinListFragment(): CoinListFragment

    @Binds
    @IntoMap
    @ViewModelKey(CoinListViewModel::class)
    abstract fun bindCoinListViewModel(viewModel: CoinListViewModel): ViewModel
}