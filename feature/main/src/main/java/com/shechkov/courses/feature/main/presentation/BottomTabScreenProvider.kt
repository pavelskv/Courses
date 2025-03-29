package com.shechkov.courses.feature.main.presentation

import com.shechkov.courses.core.navigation.ScreensProvider

interface BottomTabScreenProvider {

    fun screen(tabName: String): ScreensProvider

    class Base(
        private val homeScreen: ScreensProvider.Home,
        private val favoritesScreen: ScreensProvider.Favorites,
        private val accountScreen: ScreensProvider.Account
    ): BottomTabScreenProvider{
        override fun screen(tabName: String): ScreensProvider =
            when(tabName){
                "home" -> homeScreen
                "favorites" -> favoritesScreen
                "account" -> accountScreen
                else -> throw RuntimeException("Screen with tag $tabName not fount")
            }

    }
}