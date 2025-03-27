package com.shechkov.feature.account.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.presentation.databinding.ItemCourseBinding
import com.shechkov.core.ui.R
import com.shechkov.feature.account.databinding.ItemMyCourseBinding

fun myCourseAdapterDelegate(
    changeFavorite: ChangeFavorite,
) =
    adapterDelegateViewBinding<MyCourseUi, ItemUi, ItemMyCourseBinding>(
        { layoutInflater, root -> ItemMyCourseBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            binding.courseTitleTextView.text = item.title
            binding.dateTextView.text = item.date
            binding.rateTextView.text = item.rate

            binding.percentTextView.text = item.completionPercent
            binding.lessonsTextView.text = item.allLessonsAndCompletedCount
            binding.progressIndicatorView.setProgress(item.progress)

            binding.favoriteButton.setIconResource(if (item.hasLike) R.drawable.ic_bookmark_fill else R.drawable.ic_bookmark)
            binding.favoriteButton.setOnClickListener {
                changeFavorite.changeFavorite(item.id)
            }
        }
    }