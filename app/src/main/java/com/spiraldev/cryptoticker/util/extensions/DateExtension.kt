package com.spiraldev.cryptoticker.util.extensions

import java.text.SimpleDateFormat
import java.util.*

enum class DateFormat(val format: String) {
    yyyy_MM_dd("yyyy-MM-dd"),
    MMM_yy_w("MMM yy 'week' W"),
    MMM_yy("MMM yy")
}

fun Date?.formattedString(dateFormat: DateFormat = DateFormat.yyyy_MM_dd): String =
    try {
        SimpleDateFormat(dateFormat.format).format(this)
    } catch (e: Exception) {
        ""
    }