package com.shechkov.courses.presentation

import com.github.terrakok.cicerone.Screen
import com.shechkov.courses.core.domain.account.UserAuthorization

interface InitialScreen {

    fun screen(): Screen

    class Base(private val userAuthorization: UserAuthorization) : InitialScreen {

        override fun screen(): Screen {
            val userIsAuthorized = userAuthorization.authorized()

            return if (userIsAuthorized)
                Screens.Main()
            else Screens.Onboarding()
        }

    }

}