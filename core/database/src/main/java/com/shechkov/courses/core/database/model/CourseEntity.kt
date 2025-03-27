package com.shechkov.courses.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val text: String,
    val price: String,
    val rate: String,
    @ColumnInfo(name = "start_date")
    val startDate: Long,
    @ColumnInfo(name = "has_like")
    val hasLike: Boolean,
    @ColumnInfo(name = "publish_date")
    val publishDate: Long,
){

    fun <T> map(mapper: Mapper<T>): T = mapper.map(
        id, title, text, price, rate, startDate, hasLike, publishDate
    )

    interface Mapper<T>{
        fun map(
            id: Int,
            title: String,
            text: String,
            price: String,
            rate: String,
            startDate: Long,
            hasLike: Boolean,
            publishDate: Long
        ): T
    }

}