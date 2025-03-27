package com.shechkov.courses.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shechkov.courses.core.database.dao.CoursesDao
import com.shechkov.courses.core.database.model.CourseEntity

@Database(
    entities = [CourseEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class CoursesDatabase : RoomDatabase() {

    abstract fun coursesDao(): CoursesDao

}