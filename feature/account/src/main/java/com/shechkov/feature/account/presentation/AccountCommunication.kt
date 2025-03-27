package com.shechkov.feature.account.presentation

import com.shechkov.core.presentation.Communication
import com.shechkov.core.presentation.adapter.ItemUi

interface AccountCommunication : Communication.Update<List<ItemUi>>,
    Communication.Observe<List<ItemUi>> {
    class Base() : Communication.UiUpdate<List<ItemUi>>(), AccountCommunication
}