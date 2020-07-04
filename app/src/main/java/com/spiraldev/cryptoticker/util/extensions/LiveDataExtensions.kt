package com.spiraldev.cryptoticker.util.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> LiveData<T>.doOnChange(owner: LifecycleOwner, f: (T) -> Unit) {
    observe(owner, Observer {
        f(it)
    })
}