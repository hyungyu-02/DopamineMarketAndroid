package com.myteam.hackathonapp.data.service

import com.myteam.hackathonapp.data.dto.request.RegisterAppRequestDto
import com.myteam.hackathonapp.data.dto.response.BaseResponse
import com.myteam.hackathonapp.data.dto.response.ResponseAppsDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AppsService {
    @GET("apps")
    suspend fun getAppsData(
        @Query("userId") userId: Int
    ): BaseResponse<List<ResponseAppsDto>>

    @POST("apps")
    suspend fun registerApp(
        @Body body: RegisterAppRequestDto
    ): BaseResponse<ResponseAppsDto>
}