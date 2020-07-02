package com.spiraldev.cryptoticker.core.common

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.spiraldev.cryptoticker.core.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * [BaseActivity] contains common methods and properties and all activities must extend this class
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(
            this,
            message,
            duration
        ).show()
    }
}