package com.shechkov.core.presentation

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

interface DateUiFormat {

    fun formatLongDateToString(
        date: Long,
    ): String

    class Base(private val pattern: DateFormatPattern) : DateUiFormat {
        override fun formatLongDateToString(date: Long): String {
            val dateTime = Date(date)
            val format = SimpleDateFormat(pattern.toString(), Locale.getDefault())
            return format.format(dateTime)
        }

    }

}