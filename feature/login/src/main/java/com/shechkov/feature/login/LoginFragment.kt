package com.shechkov.feature.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.feature.login.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {
    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            emailEditText.addListener { editable ->
                val email = editable.toString()
                viewModel.checkEmailAndPasswordValid(email, passwordEditText.text())
            }
            passwordEditText.addListener { editable ->
                val password = editable.toString()
                viewModel.checkEmailAndPasswordValid(emailEditText.text(), password)
            }

            socialVkButton.setOnClickListener {
                viewModel.openSocialVK()
            }

            socialOkButton.setOnClickListener {
                viewModel.openSocialOK()
            }

            loginButton.setOnClickListener {
                viewModel.login()
            }
        }

        viewModel.observeLoginUiState(viewLifecycleOwner) {
            it.handle(binding)
        }
    }

}