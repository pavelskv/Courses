package com.shechkov.courses.di

import com.shechkov.courses.core.network.ProvideConverterFactory
import com.shechkov.courses.core.network.ProvideLoggingInterceptor
import com.shechkov.courses.core.network.ProvideOkHttpClientBuilder
import com.shechkov.courses.core.network.ProvideRetrofit
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
    fun provideRetrofit(provideRetrofit: ProvideRetrofit): Retrofit =
        provideRetrofit.retrofit()

    @Provides
    @Singleton
    fun provideRetrofitProvider(
        provideConverterFactory: ProvideConverterFactory,
        okHttpClientBuilder: ProvideOkHttpClientBuilder
    ): ProvideRetrofit =
        ProvideRetrofit.Base(provideConverterFactory, okHttpClientBuilder)

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