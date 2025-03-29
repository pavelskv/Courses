package com.shechkov.courses.feature.main.presentation

interface BottomTab {
    class Home() : BottomTab {
        override fun toString(): String = "home"
    }

    class Favorites() : BottomTab {
        override fun toString(): String = "favorites"
    }

    class Account() : BottomTab {
        override fun toString(): String = "account"
    }
}