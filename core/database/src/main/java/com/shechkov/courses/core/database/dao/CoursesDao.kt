package com.shechkov.courses.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shechkov.courses.core.database.model.CourseEntity

@Dao
interface CoursesDao {

    @Query("SELECT * FROM courses")
    fun getAllCourses(): List<CourseEntity>

    @Query("SELECT * FROM courses WHERE has_like = 1")
    fun getAllFavoritesCourses(): List<CourseEntity>

    @Query("SELECT * FROM courses WHERE id = :id")
    fun getCourseById(id: Int): CourseEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(courses: List<CourseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: CourseEntity)


}