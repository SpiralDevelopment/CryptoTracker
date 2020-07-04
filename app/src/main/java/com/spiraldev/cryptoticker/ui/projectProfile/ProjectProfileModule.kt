package com.spiraldev.cryptoticker.ui.projectProfile

import androidx.lifecycle.ViewModel
import com.spiraldev.cryptoticker.core.di.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProjectProfileModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProjectProfileViewModel::class)
    abstract fun bindProjectProfileViewModel(viewModel: ProjectProfileViewModel): ViewModel
}