package com.shechkov.core.presentation.courses

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveUpdateFavorites {
    fun observeUpdateFavorites(owner: LifecycleOwner, observer: Observer<Unit>)
}