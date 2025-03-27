package com.shechkov.feature.login.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.feature.login.LoginUiState

interface ObserveLoginUiState {
    fun observeLoginUiState(owner: LifecycleOwner, observer: Observer<LoginUiState>)
}