package com.shechkov.courses.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Replace
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val initialScreen: InitialScreen,
) : ViewModel() {

    fun init(navigator: Navigator) {
        val screen = initialScreen.screen()
        navigator.applyCommands(arrayOf<Command>(Replace(screen)))
    }
}