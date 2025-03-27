package com.shechkov.courses.core.data.courses.cloud

import com.google.gson.annotations.SerializedName

class CoursesResponse(
    @SerializedName("courses")
    private val courses: List<CourseDataCloud>
) {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(courses)

    interface Mapper<T> {
        fun map(courses: List<CourseDataCloud>): T
    }
}