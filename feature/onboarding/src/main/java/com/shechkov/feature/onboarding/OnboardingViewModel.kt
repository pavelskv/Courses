package com.shechkov.feature.onboarding

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.shechkov.courses.core.navigation.ScreensProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val router: Router,
    private val loginScreen: ScreensProvider.Login,
) : ViewModel() {
    fun navigateToLoginScreen() {
        router.navigateTo(loginScreen.provideScreen())
    }
}