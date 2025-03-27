package com.shechkov.courses.core.data.courses.cache

import com.shechkov.courses.core.data.courses.CourseData
import com.shechkov.courses.core.data.courses.CoursesData
import com.shechkov.courses.core.database.model.CourseEntity

class CourseEntityToDataMapper : CourseEntity.Mapper<CourseData> {
    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: Long,
        hasLike: Boolean,
        publishDate: Long
    ): CourseData =
        CourseData.Base(
            id, title, text, price, rate, startDate, hasLike, publishDate
        )
}