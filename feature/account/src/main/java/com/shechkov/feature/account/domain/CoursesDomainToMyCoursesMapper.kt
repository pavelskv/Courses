package com.shechkov.feature.account.domain

import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain

class CoursesDomainToMyCoursesMapper: CoursesDomain.Mapper<CoursesDomain> {
    override fun map(courses: List<CourseDomain>): CoursesDomain =
        CoursesDomain.Base(courses.take(2))

    override fun mapError(e: Exception): CoursesDomain = CoursesDomain.Error(e)
}