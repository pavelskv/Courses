package com.shechkov.feature.home.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.shechkov.core.presentation.adapter.ItemUi

interface ObserveCourses {
    fun observe(owner: LifecycleOwner, observer: Observer<List<ItemUi>>)
}