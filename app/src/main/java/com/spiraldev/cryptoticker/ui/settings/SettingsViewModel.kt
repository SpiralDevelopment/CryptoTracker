package com.spiraldev.cryptoticker.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.spiraldev.cryptoticker.core.common.BaseViewModel
import com.spiraldev.cryptoticker.data.repository.settings.SettingsRepository
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val repository: SettingsRepository) : BaseViewModel() {

    //LiveData to listen for toggle changes which indicates whether user selected dark mode or not
    private val _isDarkMode = MutableLiveData(repository.isDarkModeEnabled())
    val isDarkMode: LiveData<Boolean> = _isDarkMode

    //Called from xml on Switch toggle
    fun onThemeChanged(isDarkMode: Boolean) {
        //Update the setting in SharedPreference
        repository.setThemeMode(isDarkMode)
        this@SettingsViewModel._isDarkMode.value = isDarkMode
    }
}