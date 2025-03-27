package com.shechkov.courses.core.data.di

import com.shechkov.courses.core.data.DateFormat
import com.shechkov.courses.core.data.courses.BaseCoursesRepository
import com.shechkov.courses.core.data.courses.CourseData
import com.shechkov.courses.core.data.courses.CourseDataToDomainMapper
import com.shechkov.courses.core.data.courses.CoursesData
import com.shechkov.courses.core.data.courses.CoursesDataToDomainMapper
import com.shechkov.courses.core.data.courses.cache.CourseDataToEntityMapper
import com.shechkov.courses.core.data.courses.cache.CourseEntityToDataMapper
import com.shechkov.courses.core.data.courses.cache.CoursesCacheDataSource
import com.shechkov.courses.core.data.courses.cache.CoursesDataToEntityMapper
import com.shechkov.courses.core.data.courses.cloud.CourseDataCloud
import com.shechkov.courses.core.data.courses.cloud.CourseDataCloudToDataMapper
import com.shechkov.courses.core.data.courses.cloud.CoursesCloudDataSource
import com.shechkov.courses.core.data.courses.cloud.CoursesResponse
import com.shechkov.courses.core.data.courses.cloud.CoursesResponseToDataMapper
import com.shechkov.courses.core.data.courses.cloud.CoursesService
import com.shechkov.courses.core.database.dao.CoursesDao
import com.shechkov.courses.core.database.model.CourseEntity
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.courses.core.domain.CoursesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoursesDataModule {

//    @Provides
//    @Singleton
//    fun provideCoursesRepository(
//        coursesCloudDataSource: CoursesCloudDataSource,
//        coursesResponseToDataMapper: CoursesResponse.Mapper<CoursesData>,
//        coursesDataToDomainMapper: CoursesData.Mapper<CoursesDomain>
//    ): CoursesRepository =
//        BaseCoursesRepository(
//            coursesCloudDataSource,
//            coursesResponseToDataMapper,
//            coursesDataToDomainMapper
//        )

    @Provides
    @Singleton
    fun provideCoursesCacheDataSource(
        coursesDao: CoursesDao,
        courseEntityToDataMapper: CourseEntity.Mapper<CourseData>,
        courseDataToEntityMapper: CourseData.Mapper<CourseEntity>,
        coursesDataToEntityMapper: CoursesData.Mapper<List<CourseEntity>>
    ): CoursesCacheDataSource =
        CoursesCacheDataSource.Base(
            coursesDao,
            courseEntityToDataMapper,
            coursesDataToEntityMapper,
            courseDataToEntityMapper
        )

    @Provides
    @Singleton
    fun provideCourseEntityToDataMapper(): CourseEntity.Mapper<CourseData> =
        CourseEntityToDataMapper()

    @Provides
    @Singleton
    fun provideCourseDataToEntityMapper(): CourseData.Mapper<CourseEntity> =
        CourseDataToEntityMapper()

    @Provides
    @Singleton
    fun provideCoursesDataToEntityMapper(courseDataToEntityMapper: CourseData.Mapper<CourseEntity>): CoursesData.Mapper<List<CourseEntity>> =
        CoursesDataToEntityMapper(courseDataToEntityMapper)

    @Provides
    @Singleton
    fun provideCoursesCloudDataSource(service: CoursesService): CoursesCloudDataSource =
        CoursesCloudDataSource.Base(service)

    @Provides
    @Singleton
    fun provideCoursesService(retrofit: Retrofit): CoursesService =
        retrofit.create(CoursesService::class.java)

    @Provides
    @Singleton
    fun provideCoursesResponseToDataMapper(courseDataCloudToDataMapper: CourseDataCloud.Mapper<CourseData>): CoursesResponse.Mapper<CoursesData> =
        CoursesResponseToDataMapper(courseDataCloudToDataMapper)

    @Provides
    @Singleton
    fun provideCourseDataCloudToDataMapper(dateFormat: DateFormat): CourseDataCloud.Mapper<CourseData> =
        CourseDataCloudToDataMapper(dateFormat)

    @Provides
    @Singleton
    fun provideCoursesDataToDomainMapper(courseDataToDomainMapper: CourseData.Mapper<CourseDomain>): CoursesData.Mapper<CoursesDomain> =
        CoursesDataToDomainMapper(courseDataToDomainMapper)

    @Provides
    @Singleton
    fun provideCourseDataToDomainMapper(): CourseData.Mapper<CourseDomain> =
        CourseDataToDomainMapper()

}