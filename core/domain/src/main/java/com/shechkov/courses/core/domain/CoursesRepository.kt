package com.shechkov.courses.core.domain

interface CoursesRepository {
    suspend fun courses(): CoursesDomain
    suspend fun favorites(): CoursesDomain
    suspend fun changeFavorite(id: Int)
}