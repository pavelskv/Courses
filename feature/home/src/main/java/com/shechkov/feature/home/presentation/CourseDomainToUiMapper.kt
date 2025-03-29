package com.shechkov.feature.home.presentation

import com.shechkov.core.presentation.DateFormatPattern
import com.shechkov.core.presentation.DateUiFormat
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.ui.R
import com.shechkov.courses.core.domain.CourseDomain

class CourseDomainToUiMapper() : CourseDomain.Mapper<ItemUi> {

    private val dateUiFormat: DateUiFormat = DateUiFormat.Base(DateFormatPattern.DDMMMYYYY())

    private val images = listOf(R.drawable.cover_1, R.drawable.cover_2, R.drawable.cover_3)

    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: Long,
        hasLike: Boolean,
        publishDate: Long,
    ): ItemUi = CourseUi(
        id, title, text, "$price ₽", rate, hasLike,
        dateUiFormat.formatLongDateToString(startDate),
        images[id % 3]
    )
}