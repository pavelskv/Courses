package com.shechkov.courses.di

import com.shechkov.courses.core.data.courses.BaseCoursesRepository
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.courses.core.domain.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoursesModule {

    @Binds
    @Singleton
    abstract fun bindCoursesInteractor(baseCoursesInteractor: CoursesInteractor.Base): CoursesInteractor

    @Binds
    abstract fun bindCoursesRepository(baseCoursesRepository: BaseCoursesRepository): CoursesRepository

}