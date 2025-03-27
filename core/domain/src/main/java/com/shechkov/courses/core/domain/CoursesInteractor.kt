package com.shechkov.courses.core.domain

import javax.inject.Inject

interface CoursesInteractor {

    suspend fun courses(sortBy: CoursesSorting = CoursesSorting.Default()): CoursesDomain
    suspend fun favorites(): CoursesDomain
    suspend fun changeFavorite(id: Int)

    class Base @Inject constructor(
        private val coursesRepository: CoursesRepository,
    ) : CoursesInteractor {

        override suspend fun courses(sortBy: CoursesSorting): CoursesDomain {
            val courses = coursesRepository.courses()
            return courses.map(CoursesDomain.Mapper.Sort(sortBy))
        }

        override suspend fun favorites(): CoursesDomain = coursesRepository.favorites()
        override suspend fun changeFavorite(id: Int) = coursesRepository.changeFavorite(id)
    }
}