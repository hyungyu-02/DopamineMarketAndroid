package com.myteam.hackathonapp.data.service

import com.myteam.hackathonapp.data.dto.response.BaseResponse
import com.myteam.hackathonapp.data.dto.response.ResponseAppsDto
import retrofit2.http.Body
import retrofit2.http.GET

interface AppsService {
    @GET("apps")
    suspend fun getAppsData(
        @Body request: Int
    ): BaseResponse<ResponseAppsDto>
}