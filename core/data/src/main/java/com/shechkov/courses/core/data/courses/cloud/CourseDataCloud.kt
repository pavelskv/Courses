package com.shechkov.courses.core.data.courses.cloud

import com.google.gson.annotations.SerializedName

class CourseDataCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("title")
    private val title: String,
    @SerializedName("text")
    private val text: String,
    @SerializedName("price")
    private val price: String,
    @SerializedName("rate")
    private val rate: String,
    @SerializedName("startDate")
    private val startDate: String,
    @SerializedName("hasLike")
    private val hasLike: Boolean,
    @SerializedName("publishDate")
    private val publishDate: String,
) {

    fun <T> map(mapper: Mapper<T>): T =
        mapper.map(id, title, text, price, rate, startDate, hasLike, publishDate)

    interface Mapper<T> {
        fun map(
            id: Int,
            title: String,
            text: String,
            price: String,
            rate: String,
            startDate: String,
            hasLike: Boolean,
            publishDate: String
        ): T
    }
}