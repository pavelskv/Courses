package com.shechkov.courses.core.data.courses

import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain

class CoursesDataToDomainMapper(
    private val courseDataToDomainMapper: CourseData.Mapper<CourseDomain>
) : CoursesData.Mapper<CoursesDomain> {

    override fun map(courses: List<CourseData>): CoursesDomain =
        CoursesDomain.Base(courses.map { it.map(courseDataToDomainMapper) })

    override fun mapError(e: Exception): CoursesDomain = CoursesDomain.Error(e)
}