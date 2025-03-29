package com.shechkov.courses.feature.main.presentation

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TabContainerViewModel @Inject constructor(
    private val bottomTabScreenProvider: BottomTabScreenProvider,
) : ViewModel() {
    fun initScreen(router: Router, tabName: String) {
        val screenProvider = bottomTabScreenProvider.screen(tabName)
        val screen = screenProvider.provideScreen()

        router.replaceScreen(screen)
    }
}