package com.shechkov.feature.account.presentation.adapter

import com.shechkov.core.presentation.adapter.ItemUi

data class MyCourseUi(
    val id: Int, val title: String, val rate: String,
    val hasLike: Boolean, val date: String,
    val allLessonsAndCompletedCount: String, val completionPercent: String,
    val progress: Int
) : ItemUi