package com.spiraldev.cryptoticker.core.common

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * [BaseActivity] contains common methods and properties and all activities must extend this class
 */
abstract class BaseActivity : AppCompatActivity() {

    fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(
            this,
            message,
            duration
        ).show()
    }
}