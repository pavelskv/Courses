package com.shechkov.courses.core.data.courses

import com.shechkov.courses.core.data.courses.cache.CoursesCacheDataSource
import com.shechkov.courses.core.data.courses.cloud.CoursesCloudDataSource
import com.shechkov.courses.core.data.courses.cloud.CoursesResponse
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesRepository
import javax.inject.Inject

class BaseCoursesRepository @Inject constructor(
    private val coursesCloudDataSource: CoursesCloudDataSource,
    private val coursesCacheDataSource: CoursesCacheDataSource,
    private val coursesResponseToDataMapper: CoursesResponse.Mapper<CoursesData>,
    private val coursesDataToDomainMapper: CoursesData.Mapper<CoursesDomain>
) : CoursesRepository {
    override suspend fun courses(): CoursesDomain {
        return try {
            val cachedData = coursesCacheDataSource.courses()

            if (cachedData.map(CoursesData.Mapper.IsNotEmpty())) {
                return cachedData.map(coursesDataToDomainMapper)
            }

            val response = coursesCloudDataSource.courses()
            val coursesData = response.map(coursesResponseToDataMapper)
            coursesCacheDataSource.save(coursesData)
            return coursesData.map(coursesDataToDomainMapper)
        } catch (e: Exception) {
            CoursesDomain.Error(e)
        }
    }

    override suspend fun favorites(): CoursesDomain {
        return try {
            val coursesData = coursesCacheDataSource.favorites()
            return coursesData.map(coursesDataToDomainMapper)
        } catch (e: Exception) {
            CoursesDomain.Error(e)
        }
    }

    override suspend fun changeFavorite(id: Int) {
        val data = coursesCacheDataSource.courseById(id) ?: return
        val courseChangedFavoriteState = data.map(CourseDataChangeFavoriteMapper())
        coursesCacheDataSource.save(courseChangedFavoriteState)
    }
}