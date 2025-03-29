package com.shechkov.courses.core.domain.account

interface UserIsAuthorized {
    fun authorized(): Boolean
}

interface ChangeUserAuthorization {
    fun login()
    fun logout()
}

interface UserAuthorization : UserIsAuthorized, ChangeUserAuthorization