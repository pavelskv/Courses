package com.shechkov.feature.favorites.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.shechkov.core.presentation.adapter.ItemUi

interface ObserveFavorites {
    fun observe(owner: LifecycleOwner, observer: Observer<List<ItemUi>>)
}