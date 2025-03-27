package com.shechkov.courses.core.data.courses.cloud

import com.shechkov.courses.core.data.DateFormat
import com.shechkov.courses.core.data.courses.CourseData

class CourseDataCloudToDataMapper(
    private val dateFormat: DateFormat,
) : CourseDataCloud.Mapper<CourseData> {
    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: String,
        hasLike: Boolean,
        publishDate: String,
    ): CourseData {
        val startDateLong = dateFormat.convertDateStringToLong(startDate)
        val publishDateLong = dateFormat.convertDateStringToLong(publishDate)
        return CourseData.Base(
            id,
            title,
            text,
            price,
            rate,
            startDateLong,
            hasLike,
            publishDateLong
        )
    }
}