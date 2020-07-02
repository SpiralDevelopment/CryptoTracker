package com.spiraldev.cryptoticker.core.common

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.spiraldev.cryptoticker.core.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


interface InitViews {
    fun initializeViews()
    fun observeViewModel()
}

abstract class BaseFragment : DaggerFragment(), InitViews {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(
            context,
            message,
            duration
        ).show()
    }
}