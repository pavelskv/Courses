package com.shechkov.feature.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.feature.login.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {
    override val viewModel: LoginViewModel by viewModels()

}