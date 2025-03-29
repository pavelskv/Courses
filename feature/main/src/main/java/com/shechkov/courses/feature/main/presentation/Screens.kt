package com.shechkov.courses.feature.main.presentation

import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun Tab(tabName: String) = FragmentScreen {
        TabContainerFragment.getNewInstance(tabName)
    }
}