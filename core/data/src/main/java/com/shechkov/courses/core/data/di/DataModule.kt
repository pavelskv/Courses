package com.shechkov.courses.core.data.di

import com.shechkov.courses.core.data.DateFormat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDateFormat(): DateFormat =
        DateFormat.Base()

}