package com.spiraldev.cryptoticker.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import com.spiraldev.cryptoticker.core.common.BaseViewModel
import com.spiraldev.cryptoticker.data.repository.settings.SettingsRepository
import javax.inject.Inject

class HomeActivityViewModel @ViewModelInject constructor(private val repository: SettingsRepository) : BaseViewModel() {

    fun isDarkModeOn () : Boolean{
        return repository.isDarkModeEnabled()
    }
}