package com.shechkov.courses.core.data.courses.cloud

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CoursesService {

    @GET
    suspend fun courses(@Url url: String): Response<CoursesResponse>

}