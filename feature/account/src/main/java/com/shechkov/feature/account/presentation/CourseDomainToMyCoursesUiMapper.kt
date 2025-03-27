package com.shechkov.feature.account.presentation

import com.shechkov.core.presentation.DateFormatPattern
import com.shechkov.core.presentation.DateUiFormat
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.feature.account.presentation.adapter.MyCourseUi

class CourseDomainToMyCoursesUiMapper : CourseDomain.Mapper<MyCourseUi> {
    override fun map(
        id: Int,
        title: String,
        text: String,
        price: String,
        rate: String,
        startDate: Long,
        hasLike: Boolean,
        publishDate: Long,
    ): MyCourseUi {
        val dateUiFormat = DateUiFormat.Base(DateFormatPattern.DDMMMYYYY())
        val lessonsCount = (30..50).random().toFloat()
        val completedLessonsCount = (0..30).random()
        val percent = ((completedLessonsCount / lessonsCount) * 100).toInt()

        val allLessonsAndCompletedCount = "$completedLessonsCount/${lessonsCount.toInt()} уроков"

        val completionPercent = "$percent%"

        return MyCourseUi(
            id, title, rate, hasLike, dateUiFormat.formatLongDateToString(startDate),
            allLessonsAndCompletedCount, completionPercent, percent
        )
    }
}