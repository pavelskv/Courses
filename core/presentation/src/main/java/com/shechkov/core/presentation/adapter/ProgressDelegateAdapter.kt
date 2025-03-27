package com.shechkov.core.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.core.presentation.databinding.ItemProgressBinding
import com.shechkov.core.ui.R

fun progressAdapterDelegate() =
    adapterDelegateViewBinding<ProgressUi, ItemUi, ItemProgressBinding>(
        { layoutInflater, root -> ItemProgressBinding.inflate(layoutInflater, root, false) }
    ) {

    }