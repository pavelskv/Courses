package com.shechkov.courses.core.data.courses.cache

import com.shechkov.courses.core.data.courses.CourseData
import com.shechkov.courses.core.database.model.CourseEntity

class CourseDataToEntityMapper : CourseData.Mapper<CourseEntity> {
    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: Long,
        hasLike: Boolean,
        publishDate: Long
    ): CourseEntity =
        CourseEntity(id, title, text, price, rate, startDate, hasLike, publishDate)
}