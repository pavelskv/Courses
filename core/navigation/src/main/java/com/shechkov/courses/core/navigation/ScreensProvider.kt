package com.shechkov.courses.core.navigation

import com.github.terrakok.cicerone.Screen

interface ScreensProvider {

    fun provideScreen(): Screen

    abstract class Abstract(private val screen: Screen) : ScreensProvider {
        override fun provideScreen(): Screen = screen
    }

    class Login(screen: Screen) : Abstract(screen)
    class Main(screen: Screen) : Abstract(screen)

    class Home(screen: Screen): Abstract(screen)
    class Favorites(screen: Screen): Abstract(screen)
    class Account(screen: Screen): Abstract(screen)

    class Onboarding(screen: Screen): Abstract(screen)

}