package com.shechkov.courses.core.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

interface ProvideOkHttpClientBuilder {

    fun httpClientBuilder(): OkHttpClient.Builder

    class Base(
        private val provideLoggingInterceptor: ProvideLoggingInterceptor,
        private val timeOutSeconds: Long = 60L,
    ) : ProvideOkHttpClientBuilder {

        override fun httpClientBuilder(): OkHttpClient.Builder =
            OkHttpClient.Builder()
                .addInterceptor(provideLoggingInterceptor.interceptor())
                .connectTimeout(timeOutSeconds, TimeUnit.SECONDS)
                .readTimeout(timeOutSeconds, TimeUnit.SECONDS)

    }

}