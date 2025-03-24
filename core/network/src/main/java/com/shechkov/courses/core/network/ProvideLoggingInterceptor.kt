package com.shechkov.courses.core.network

import okhttp3.logging.HttpLoggingInterceptor

interface ProvideLoggingInterceptor {

    fun interceptor(): HttpLoggingInterceptor

    abstract class Abstract(
        private val loggingLevel: HttpLoggingInterceptor.Level
    ) : ProvideLoggingInterceptor {

        override fun interceptor() = HttpLoggingInterceptor().apply {
            level = loggingLevel
        }
    }

    class Base : Abstract(HttpLoggingInterceptor.Level.NONE) {
        private val loggingInterceptor = if (BuildConfig.DEBUG) Debug() else Release()

        override fun interceptor() = loggingInterceptor.interceptor()
    }

    class Debug : Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : Abstract(HttpLoggingInterceptor.Level.NONE)
}