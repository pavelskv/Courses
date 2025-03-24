package com.shechkov.courses.core.network.di

import com.shechkov.courses.core.network.ProvideConverterFactory
import com.shechkov.courses.core.network.ProvideLoggingInterceptor
import com.shechkov.courses.core.network.ProvideOkHttpClientBuilder
import com.shechkov.courses.core.network.ProvideRetrofitBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitBuilder(
        provideConverterFactory: ProvideConverterFactory,
        okHttpClientBuilder: ProvideOkHttpClientBuilder
    ): ProvideRetrofitBuilder =
        ProvideRetrofitBuilder.Base(provideConverterFactory, okHttpClientBuilder)

    @Provides
    @Singleton
    fun provideConverterFactory(): ProvideConverterFactory =
        ProvideConverterFactory.Base()

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        loggingInterceptor: ProvideLoggingInterceptor,
    ): ProvideOkHttpClientBuilder =
        ProvideOkHttpClientBuilder.Base(loggingInterceptor)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): ProvideLoggingInterceptor =
        ProvideLoggingInterceptor.Base()


}