package com.shechkov.feature.onboarding

import com.shechkov.core.presentation.adapter.ItemUi

class OnboardingCourseUi(
    val title: String,
    val selected: Boolean = false
) : ItemUi {
    override fun id() = title
}