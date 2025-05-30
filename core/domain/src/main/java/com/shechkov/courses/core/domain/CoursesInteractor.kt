package com.shechkov.courses.core.domain

import javax.inject.Inject

interface CoursesInteractor {

    suspend fun courses(): CoursesDomain
    suspend fun courses(sortBy: CoursesSorting = CoursesSorting.Default()): CoursesDomain
    suspend fun favorites(): CoursesDomain
    suspend fun changeFavorite(id: Int)

    class Base @Inject constructor(
        private val coursesRepository: CoursesRepository,
    ) : CoursesInteractor {

        private var sort: CoursesSorting = CoursesSorting.Default()

        override suspend fun courses(): CoursesDomain = courses(sort)

        override suspend fun courses(sortBy: CoursesSorting): CoursesDomain {
            sort = sortBy
            val courses = coursesRepository.courses()
            return courses.map(CoursesDomain.Mapper.Sort(sortBy))
        }

        override suspend fun favorites(): CoursesDomain = coursesRepository.favorites()
        override suspend fun changeFavorite(id: Int) = coursesRepository.changeFavorite(id)
    }
}