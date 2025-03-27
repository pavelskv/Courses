package com.shechkov.courses.core.data.courses.cloud

import com.shechkov.courses.core.data.CloudDataSource

interface CoursesCloudDataSource {

    suspend fun courses(): CoursesResponse

    class Base(
        private val service: CoursesService
    ) : CloudDataSource.Abstract(), CoursesCloudDataSource {

        override suspend fun courses(): CoursesResponse = handle { service.courses(URL) }

        companion object{
            private const val URL = "https://drive.usercontent.google.com/u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download"
        }
    }


}