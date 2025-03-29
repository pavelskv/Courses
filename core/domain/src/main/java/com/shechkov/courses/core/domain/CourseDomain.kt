package com.shechkov.courses.core.domain

interface CourseDomain {

    fun <T> map(mapper: Mapper<T>): T

    interface Mapper<T> {
        fun map(
            id: Int,
            title: String,
            text: String,
            price: String,
            rate: String,
            startDate: Long,
            hasLike: Boolean,
            publishDate: Long,
        ): T

        class PublishDate : Mapper<Long> {
            override fun map(
                id: Int,
                title: String,
                text: String,
                price: String,
                rate: String,
                startDate: Long,
                hasLike: Boolean,
                publishDate: Long,
            ): Long = publishDate

        }
    }

    class Base(
        private val id: Int,
        private val title: String,
        private val text: String,
        private val price: String,
        private val rate: String,
        private val startDate: Long,
        private val hasLike: Boolean,
        private val publishDate: Long
    ) : CourseDomain {
        override fun <T> map(mapper: Mapper<T>): T =
            mapper.map(id, title, text, price, rate, startDate, hasLike, publishDate)

    }

}