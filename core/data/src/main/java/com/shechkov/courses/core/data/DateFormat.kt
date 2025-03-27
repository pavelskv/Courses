package com.shechkov.courses.core.data

import java.text.SimpleDateFormat
import java.util.Locale

interface DateFormat {

    fun convertDateStringToLong(date: String): Long

    class Base() : DateFormat {

        override fun convertDateStringToLong(date: String): Long {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return format.parse(date)?.time ?: 0L
        }

    }

}