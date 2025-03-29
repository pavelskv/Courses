package com.shechkov.feature.onboarding

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.ui.R
import com.shechkov.feature.onboarding.databinding.ItemCourseOnboardingBinding

fun onboardingCoursesDelegate() =
    adapterDelegateViewBinding<OnboardingCourseUi, ItemUi, ItemCourseOnboardingBinding>(
        { layoutInflater, root -> ItemCourseOnboardingBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            binding.root.text = item.title
            binding.root.rotation = if (item.selected) -15F else 0F
            binding.root.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    binding.root.context,
                    if (item.selected) R.color.green else R.color.light_gray_50
                )
            )
            binding.root.z = if (item.selected) 1f else 0f
        }
    }