package com.shechkov.courses.domain

import android.content.SharedPreferences
import com.shechkov.courses.core.domain.account.UserAuthorization
import androidx.core.content.edit

class BaseUserAuthorization(private val sharedPreferences: SharedPreferences) : UserAuthorization {

    override fun authorized(): Boolean = sharedPreferences.getBoolean(KEY, false)

    override fun login() {
        changeAuthState(true)
    }

    override fun logout() {
        changeAuthState(false)
    }

    private fun changeAuthState(authorized: Boolean) {
        sharedPreferences.edit { putBoolean(KEY, authorized) }
    }

    companion object {
        private const val KEY = "USER_AUTHORIZED"
    }
}

