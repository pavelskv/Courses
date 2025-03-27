package com.shechkov.core.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.core.presentation.databinding.ItemProgressBinding
import com.shechkov.core.presentation.databinding.ItemTitleBinding
import com.shechkov.core.ui.R

fun titleDelegate() =
    adapterDelegateViewBinding<TitleUi, ItemUi, ItemTitleBinding>(
        { layoutInflater, root -> ItemTitleBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.root.setText(item.title)
        }
    }