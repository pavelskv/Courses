package com.shechkov.feature.home.di

import com.shechkov.core.presentation.DateUiFormat
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.courses.core.domain.CoursesRepository
import com.shechkov.feature.home.presentation.CourseDomainToUiMapper
import com.shechkov.feature.home.presentation.CoursesCommunication
import com.shechkov.feature.home.presentation.CoursesDomainToUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {

    @Provides
    @ViewModelScoped
    fun provideCoursesDomainToUiMapper(courseDomainToUiMapper: CourseDomain.Mapper<ItemUi>): CoursesDomain.Mapper<List<ItemUi>> =
        CoursesDomainToUiMapper(courseDomainToUiMapper)

    @Provides
    @ViewModelScoped
    fun provideCourseDomainToUiMapper(): CourseDomain.Mapper<ItemUi> =
        CourseDomainToUiMapper()

    @Provides
    @ViewModelScoped
    fun provideCoursesCommunication(): CoursesCommunication = CoursesCommunication.Base()

}