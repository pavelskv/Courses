package com.shechkov.feature.account.presentation

import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.feature.account.presentation.adapter.MyCourseUi

class CoursesDomainToMyCoursesUiMapper(
    private val courseDomainToMyCourseUiMapper: CourseDomain.Mapper<MyCourseUi>,
) : CoursesDomain.Mapper<List<MyCourseUi>> {
    override fun map(courses: List<CourseDomain>): List<MyCourseUi> =
        courses.map { it.map(courseDomainToMyCourseUiMapper) }

    override fun mapError(e: Exception): List<MyCourseUi> = listOf()
}