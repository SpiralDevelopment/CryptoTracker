package com.spiraldev.cryptoticker.ui.home

import androidx.lifecycle.ViewModel
import com.spiraldev.cryptoticker.core.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(viewModel: HomeActivityViewModel): ViewModel
}