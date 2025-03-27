package com.shechkov.courses.core.domain

interface CoursesSorting {

    fun sort(data: List<CourseDomain>): List<CourseDomain>

    class Default() : CoursesSorting {
        override fun sort(data: List<CourseDomain>): List<CourseDomain> = data
    }

    class PublishDateDesc() : CoursesSorting {
        override fun sort(data: List<CourseDomain>): List<CourseDomain> {
            return data.sortedBy { it.map(CourseDomain.Mapper.PublishDate()) }
        }
    }

}