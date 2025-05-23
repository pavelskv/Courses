package com.shechkov.feature.login

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.shechkov.core.presentation.OpenBrowser
import com.shechkov.courses.core.domain.account.UserAuthorization
import com.shechkov.courses.core.navigation.ScreensProvider
import com.shechkov.feature.login.presentation.LoginCommunication
import com.shechkov.feature.login.presentation.ObserveLoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginCommunication: LoginCommunication,
    private val openBrowser: OpenBrowser,
    private val router: Router,
    private val screenMain: ScreensProvider.Main,
    private val userAuthorization: UserAuthorization,
) : ViewModel(), ObserveLoginUiState {

    private val emailValidator: FieldsValidator = FieldsValidator.Email()
    private val passwordValidator: FieldsValidator = FieldsValidator.Password()

    fun checkEmailAndPasswordValid(email: String, password: String) {
        val emailValid = emailValidator.isValid(email)
        val passwordValid = passwordValidator.isValid(password)

        val loginUiState = LoginUiState.LoginButtonState(emailValid && passwordValid)
        loginCommunication.setValue(loginUiState)
    }

    override fun observeLoginUiState(
        owner: LifecycleOwner,
        observer: Observer<LoginUiState>,
    ) = loginCommunication.observe(owner, observer)

    fun openSocialOK() {
        openBrowser.open("https://ok.ru")
    }

    fun openSocialVK() {
        openBrowser.open("https://vk.com")
    }

    fun login() {
        router.newRootScreen(screenMain.provideScreen())
        userAuthorization.login()
    }


}