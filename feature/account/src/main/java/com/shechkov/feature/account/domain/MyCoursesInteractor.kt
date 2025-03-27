package com.shechkov.feature.account.domain

import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesRepository

interface MyCoursesInteractor {

    suspend fun courses(): CoursesDomain
    suspend fun changeFavorite(id: Int)

    class Base(
        private val coursesRepository: CoursesRepository,
        private val coursesDomainToMyCoursesMapper: CoursesDomain.Mapper<CoursesDomain>,
    ) : MyCoursesInteractor {
        override suspend fun courses(): CoursesDomain {
            val courses = coursesRepository.courses()
            return courses.map(coursesDomainToMyCoursesMapper)
        }

        override suspend fun changeFavorite(id: Int) = coursesRepository.changeFavorite(id)
    }
}