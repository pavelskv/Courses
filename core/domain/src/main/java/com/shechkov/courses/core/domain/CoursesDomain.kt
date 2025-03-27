package com.shechkov.courses.core.domain

interface CoursesDomain {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun map(courses: List<CourseDomain>): T
        fun mapError(e: Exception): T

        class Sort(private val sorting: CoursesSorting) : Mapper<CoursesDomain> {
            override fun map(courses: List<CourseDomain>): CoursesDomain {
                val sortedList = sorting.sort(courses)
                return CoursesDomain.Base(sortedList)
            }

            override fun mapError(e: Exception): CoursesDomain = CoursesDomain.Error(e)

        }
    }

    class Base(private val courses: List<CourseDomain>) : CoursesDomain {
        override fun <T> map(mapper: Mapper<T>): T = mapper.map(courses)
    }

    class Error(private val exception: Exception) : CoursesDomain {
        override fun <T> map(mapper: Mapper<T>): T = mapper.mapError(exception)
    }
}