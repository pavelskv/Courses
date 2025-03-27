package com.shechkov.courses.core.network

import retrofit2.Retrofit

interface ProvideRetrofit {

    fun retrofit(): Retrofit

    class Base(
        private val provideConverterFactory: ProvideConverterFactory,
        private val httpClientBuilder: ProvideOkHttpClientBuilder,
    ) : ProvideRetrofit {
        override fun retrofit(): Retrofit =
            Retrofit.Builder()
                .addConverterFactory(provideConverterFactory.converterFactory())
                .client(httpClientBuilder.httpClientBuilder().build())
                .baseUrl("http://localhost")
                .build()

    }
}