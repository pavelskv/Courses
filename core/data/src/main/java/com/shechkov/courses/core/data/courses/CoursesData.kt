package com.shechkov.courses.core.data.courses

import com.shechkov.courses.core.domain.CourseDomain

interface CoursesData {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun map(courses: List<CourseData>): T
        fun mapError(e: Exception): T

        class IsNotEmpty() : Mapper<Boolean> {
            override fun map(courses: List<CourseData>): Boolean =
                courses.isNotEmpty()

            override fun mapError(e: Exception): Boolean = false

        }
    }

    class Base(private val courses: List<CourseData>) : CoursesData {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(courses)
    }

    class Error(private val exception: Exception) : CoursesData {
        override fun <T> map(mapper: Mapper<T>): T = mapper.mapError(exception)
    }
}