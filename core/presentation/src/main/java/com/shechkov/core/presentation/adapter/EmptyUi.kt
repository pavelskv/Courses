package com.shechkov.core.presentation.adapter

import androidx.annotation.StringRes
import com.shechkov.core.ui.R

class EmptyUi(val messageResId: Int = R.string.core_ui_empty) : ItemUi {
    override fun id() = "empty_ui"
}