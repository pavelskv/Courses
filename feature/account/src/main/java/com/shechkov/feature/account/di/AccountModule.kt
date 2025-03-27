package com.shechkov.feature.account.di

import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesRepository
import com.shechkov.feature.account.domain.CoursesDomainToMyCoursesMapper
import com.shechkov.feature.account.domain.MyCoursesInteractor
import com.shechkov.feature.account.presentation.AccountCommunication
import com.shechkov.feature.account.presentation.CourseDomainToMyCoursesUiMapper
import com.shechkov.feature.account.presentation.CoursesDomainToMyCoursesUiMapper
import com.shechkov.feature.account.presentation.adapter.MyCourseUi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class AccountModule {

    @Provides
    @ViewModelScoped
    fun provideAccountCommunication(): AccountCommunication = AccountCommunication.Base()

    @Provides
    @ViewModelScoped
    fun provideMyCoursesInteractor(coursesRepository: CoursesRepository): MyCoursesInteractor =
        MyCoursesInteractor.Base(coursesRepository, CoursesDomainToMyCoursesMapper())

    @Provides
    @ViewModelScoped
    fun provideCoursesDomainToMyCoursesUiMapper(courseDomainToMyCourseUiMapper: CourseDomain.Mapper<MyCourseUi>): CoursesDomain.Mapper<List<MyCourseUi>> =
        CoursesDomainToMyCoursesUiMapper(courseDomainToMyCourseUiMapper)

    @Provides
    @ViewModelScoped
    fun provideCourseDomainToMyCourseUiMapper(): CourseDomain.Mapper<MyCourseUi> =
        CourseDomainToMyCoursesUiMapper()

}