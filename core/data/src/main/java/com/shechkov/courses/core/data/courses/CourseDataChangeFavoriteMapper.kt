package com.shechkov.courses.core.data.courses

class CourseDataChangeFavoriteMapper : CourseData.Mapper<CourseData> {
    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: Long,
        hasLike: Boolean,
        publishDate: Long
    ): CourseData {
        val changedFavoriteState = !hasLike
        return CourseData.Base(id, title, text, price, rate, startDate, changedFavoriteState, publishDate)
    }
}