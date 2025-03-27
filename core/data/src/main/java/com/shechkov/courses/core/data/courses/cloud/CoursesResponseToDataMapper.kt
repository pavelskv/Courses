package com.shechkov.courses.core.data.courses.cloud

import com.shechkov.courses.core.data.courses.CourseData
import com.shechkov.courses.core.data.courses.CoursesData

class CoursesResponseToDataMapper(
    private val courseDataCloudToDataMapper: CourseDataCloud.Mapper<CourseData>
) : CoursesResponse.Mapper<CoursesData> {
    override fun map(courses: List<CourseDataCloud>): CoursesData =
        CoursesData.Base(courses.map { it.map(courseDataCloudToDataMapper) })
}