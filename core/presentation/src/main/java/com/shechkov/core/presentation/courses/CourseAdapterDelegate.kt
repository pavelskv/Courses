package com.shechkov.core.presentation.courses

import androidx.core.content.ContextCompat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.databinding.ItemCourseBinding
import com.shechkov.core.ui.R

fun courseAdapterDelegate(
    changeFavorite: ChangeFavorite,
) =
    adapterDelegateViewBinding<CourseUi, ItemUi, ItemCourseBinding>(
        { layoutInflater, root -> ItemCourseBinding.inflate(layoutInflater, root, false) }
    ) {

        bind {
            binding.courseTitleTextView.text = item.title
            binding.courseDescriptionTextView.text = item.text
            binding.coursePriceTextView.text = item.price
            binding.dateTextView.text = item.date
            binding.rateTextView.text = item.rate

            binding.favoriteButton.setIconResource(if (item.hasLike) R.drawable.ic_bookmark_fill else R.drawable.ic_bookmark)

            binding.favoriteButton.setOnClickListener {
                changeFavorite.changeFavorite(item.id)
            }
        }
    }