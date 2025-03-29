package com.shechkov.core.presentation.adapter

import androidx.annotation.StringRes

class TitleUi(
    @StringRes
    val title: Int,
) : ItemUi {
    override fun id() = title
}