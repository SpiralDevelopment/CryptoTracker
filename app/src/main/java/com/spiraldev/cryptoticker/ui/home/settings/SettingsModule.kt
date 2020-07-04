package com.spiraldev.cryptoticker.ui.home.settings

import androidx.lifecycle.ViewModel
import com.spiraldev.cryptoticker.core.di.annotations.FragmentScope
import com.spiraldev.cryptoticker.core.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SettingsModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel
}