package com.shechkov.courses.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Replace
import com.shechkov.core.presentation.NavigationCommunication
import com.shechkov.core.presentation.NavigationState
import com.shechkov.core.presentation.ObserveNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigationCommunication: NavigationCommunication,
    private val initialScreen: InitialScreen,
) : ViewModel(), ObserveNavigation {

    override fun observeNavigation(
        owner: LifecycleOwner,
        observer: Observer<NavigationState>,
    ) = navigationCommunication.observe(owner, observer)

    fun init(navigator: Navigator) {
        val screen = initialScreen.screen()
        navigator.applyCommands(arrayOf<Command>(Replace(screen)))
    }
}