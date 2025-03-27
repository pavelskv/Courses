package com.shechkov.courses.core.data.courses

import com.shechkov.courses.core.domain.CourseDomain

class CourseDataToDomainMapper : CourseData.Mapper<CourseDomain> {
    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: Long,
        hasLike: Boolean,
        publishDate: Long
    ): CourseDomain {
        return CourseDomain.Base(id, title, text, price, rate, startDate, hasLike, publishDate)
    }
}