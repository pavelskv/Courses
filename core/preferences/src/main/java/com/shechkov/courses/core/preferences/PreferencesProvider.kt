package com.shechkov.courses.core.preferences

import android.content.Context
import android.content.SharedPreferences

interface PreferencesProvider {

    fun provideSharedPreferences(): SharedPreferences

    class Base(private val context: Context) : PreferencesProvider {

        private companion object{
            private const val PREFERENCES_KEY = "CoursesAppSharedPref_"
        }

        override fun provideSharedPreferences(): SharedPreferences =
            context.getSharedPreferences(PREFERENCES_KEY + context.packageName, Context.MODE_PRIVATE)

    }

}