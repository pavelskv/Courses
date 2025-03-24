package com.shechkov.courses.core.network

import com.google.gson.GsonBuilder
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

interface ProvideConverterFactory {

    fun converterFactory(): Converter.Factory

    class Base : ProvideConverterFactory {
        override fun converterFactory(): Converter.Factory =
            GsonConverterFactory.create(GsonBuilder().create())
    }
}