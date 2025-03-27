package com.shechkov.feature.login.presentation

import com.shechkov.core.presentation.Communication
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.feature.login.LoginUiState

interface LoginCommunication : Communication.Update<LoginUiState>,
    Communication.Observe<LoginUiState> {
    class Base() : Communication.UiUpdate<LoginUiState>(), LoginCommunication
}