package com.shechkov.feature.login

import com.shechkov.feature.login.databinding.FragmentLoginBinding

interface LoginUiState {

    fun handle(binding: FragmentLoginBinding)

    class LoginButtonState(private val enabled: Boolean) : LoginUiState {
        override fun handle(binding: FragmentLoginBinding) {
            binding.loginButton.isEnabled = enabled
        }

    }

}