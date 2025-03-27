package com.shechkov.courses.core.database.di

import android.content.Context
import androidx.room.Room
import com.shechkov.courses.core.database.CoursesDatabase
import com.shechkov.courses.core.database.dao.CoursesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): CoursesDatabase = Room.databaseBuilder(
        context,
        CoursesDatabase::class.java,
        "courses-database",
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideCoursesDao(database: CoursesDatabase): CoursesDao = database.coursesDao()

}