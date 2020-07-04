package com.spiraldev.cryptoticker.ui.home.settings

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spiraldev.cryptoticker.core.common.BaseViewModel
import com.spiraldev.cryptoticker.data.repository.settings.SettingsRepository
import javax.inject.Inject

class SettingsViewModel @ViewModelInject constructor(private val repository: SettingsRepository) : BaseViewModel() {

    private val _isDarkMode = MutableLiveData(repository.isDarkModeEnabled())
    val isDarkMode: LiveData<Boolean> = _isDarkMode

    fun onThemeChanged(isDarkMode: Boolean) {
        repository.setThemeMode(isDarkMode)
        this@SettingsViewModel._isDarkMode.value = isDarkMode
    }
}