package com.spiraldev.cryptoticker.core.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {
    //LiveData to show ProgressBar in views. Updated by viewmodel classes
    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    //LiveData to show toast for any error
    protected val _toastError = MutableLiveData<String>()
    val toastError: LiveData<String> = _toastError
}