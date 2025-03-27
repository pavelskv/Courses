package com.shechkov.courses.core.data.courses.cache

import com.shechkov.courses.core.data.courses.CourseData
import com.shechkov.courses.core.data.courses.CoursesData
import com.shechkov.courses.core.database.model.CourseEntity

class CoursesDataToEntityMapper(
    private val courseDataToEntityMapper: CourseData.Mapper<CourseEntity>
) : CoursesData.Mapper<List<CourseEntity>> {
    override fun map(courses: List<CourseData>): List<CourseEntity> =
        courses.map { it.map(courseDataToEntityMapper) }

    override fun mapError(e: Exception): List<CourseEntity> = listOf()
}