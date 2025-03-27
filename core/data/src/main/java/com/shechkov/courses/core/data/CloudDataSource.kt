package com.shechkov.courses.core.data

import retrofit2.Response

interface CloudDataSource {

    suspend fun <T> handle(block: suspend () -> Response<T>): T

    abstract class Abstract() : CloudDataSource {

        override suspend fun <T> handle(
            block: suspend () -> Response<T>
        ): T =
            try {
                val response = block.invoke()
                val body = response.body()

                body ?: throw IllegalStateException("Service unavailable")
            } catch (error: Exception) {
                throw IllegalStateException("Service unavailable")
            }
    }
}