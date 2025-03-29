package com.shechkov.core.presentation.courses

import com.shechkov.core.presentation.adapter.ItemUi

data class CourseUi(
    val id: Int, val title: String, val text: String, val price: String,
    val rate: String,
    val hasLike: Boolean, val date: String, val imageResId: Int,
) : ItemUi {
    override fun id() = id
}