package com.shechkov.courses.core.data.courses.cache

import com.shechkov.courses.core.data.courses.CourseData
import com.shechkov.courses.core.data.courses.CoursesData
import com.shechkov.courses.core.database.dao.CoursesDao
import com.shechkov.courses.core.database.model.CourseEntity
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface CoursesCacheDataSource {

    suspend fun courses(): CoursesData
    suspend fun favorites(): CoursesData
    suspend fun courseById(id: Int): CourseData?
    suspend fun save(courseData: CourseData)
    suspend fun save(coursesData: CoursesData)

    class Base(
        private val coursesDao: CoursesDao,
        private val courseEntityToDataMapper: CourseEntity.Mapper<CourseData>,
        private val coursesDataToEntityMapper: CoursesData.Mapper<List<CourseEntity>>,
        private val courseDataToEntityMapper: CourseData.Mapper<CourseEntity>
    ) : CoursesCacheDataSource {

        private val mutex = Mutex()

        override suspend fun courses(): CoursesData = mutex.withLock {
            val data = coursesDao.getAllCourses()
            CoursesData.Base(data.map { it.map(courseEntityToDataMapper) })
        }

        override suspend fun favorites(): CoursesData = mutex.withLock {
            val data = coursesDao.getAllFavoritesCourses()
            CoursesData.Base(data.map { it.map(courseEntityToDataMapper) })
        }

        override suspend fun courseById(id: Int): CourseData? {
            val course =
                coursesDao.getCourseById(id) ?: return null
            return course.map(courseEntityToDataMapper)
        }

        override suspend fun save(courseData: CourseData) {
            val courseEntity = courseData.map(courseDataToEntityMapper)
            coursesDao.insert(courseEntity)
        }

        override suspend fun save(coursesData: CoursesData) {
            val coursesEntity = coursesData.map(coursesDataToEntityMapper)
            coursesDao.insertAll(coursesEntity)
        }
    }


}