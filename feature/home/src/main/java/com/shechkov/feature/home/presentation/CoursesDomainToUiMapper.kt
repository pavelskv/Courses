package com.shechkov.feature.home.presentation

import com.shechkov.core.presentation.adapter.EmptyUi
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.ui.R
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain

class CoursesDomainToUiMapper(
    private val courseDomainToUiMapper: CourseDomain.Mapper<ItemUi>,
) : CoursesDomain.Mapper<List<ItemUi>> {
    override fun map(courses: List<CourseDomain>): List<ItemUi> =
        courses.map { it.map(courseDomainToUiMapper) }

    override fun mapError(e: Exception): List<ItemUi> = listOf(EmptyUi(R.string.core_ui_error))
}