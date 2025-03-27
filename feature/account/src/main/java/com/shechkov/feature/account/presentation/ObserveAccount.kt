package com.shechkov.feature.account.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.shechkov.core.presentation.adapter.ItemUi

interface ObserveAccount {
    fun observe(owner: LifecycleOwner, observer: Observer<List<ItemUi>>)
}