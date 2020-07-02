package com.spiraldev.cryptoticker.data.repository.settings

import com.spiraldev.cryptoticker.data.local.prefs.SharedPreferenceStorage
import javax.inject.Inject

/**
 * [SettingsRepository] is to manage preference for dark mode option
 */
class SettingsRepository @Inject constructor(private val preferenceStorage: SharedPreferenceStorage) {

    fun isDarkModeEnabled(): Boolean {
        return preferenceStorage.isDarkMode
    }

    fun setThemeMode(isDarkMode: Boolean) {
        preferenceStorage.isDarkMode = isDarkMode
    }
}