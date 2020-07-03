package com.spiraldev.cryptoticker.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.spiraldev.cryptoticker.util.extensions.formattedDate
import com.spiraldev.cryptoticker.util.extensions.formattedString
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//Shared Preference keys
interface PreferenceStorage {
    var timeLoadedAt: Long
    var isDarkMode: Boolean
}

/**
 * [SharedPreferenceStorage] manages the preference for the app.
 */
@Singleton
class SharedPreferenceStorage @Inject constructor(context: Context) : PreferenceStorage {

    companion object {
        const val PREFS_NAME = "com.spiraldev.cryptoticker"
        const val PREFS_TIME_LOADED_AT = "prefs_data_loaded_at"
        const val PREFS_IS_DARK_MODE = "prefs_is_dark_mode"
    }

    //Create shared preference object on first use
    private val prefs: Lazy<SharedPreferences> = lazy {
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    override var timeLoadedAt by LongPreference(prefs, PREFS_TIME_LOADED_AT, 0)

    override var isDarkMode by BooleanPreference(prefs, PREFS_IS_DARK_MODE, false)
}

class BooleanPreference(
    private val preferences: Lazy<SharedPreferences>,
    private val name: String,
    private val defaultValue: Boolean
) : ReadWriteProperty<Any, Boolean> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
        return preferences.value.getBoolean(name, defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        preferences.value.edit { putBoolean(name, value) }
    }
}

class LongPreference(
    private val preferences: Lazy<SharedPreferences>,
    private val name: String,
    private val defaultValue: Long
) : ReadWriteProperty<Any, Long> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Long {
        return preferences.value.getLong(name, defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) {
        preferences.value.edit { putLong(name, value) }
    }
}