package com.myteam.hackathonapp.data.service

import com.myteam.hackathonapp.data.dto.request.RoutineRequestDto
import com.myteam.hackathonapp.data.dto.response.BaseResponse
import com.myteam.hackathonapp.data.dto.response.RoutineListResponseDto
import com.myteam.hackathonapp.data.dto.response.RoutineRequestResponseDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RoutineService {

    @POST("routines")
    suspend fun registerRoutine(@Body request: RoutineRequestDto): BaseResponse<RoutineRequestResponseDto>

    @GET("routines")
    suspend fun getRoutineList(@Query("userId") userId: Int): BaseResponse<RoutineListResponseDto>

    @DELETE("routines/{routineId}")
    suspend fun deleteRoutine(@Path("routineId") routineId: Int): BaseResponse<Unit>

    @POST("routines/{routineId}/complete")
    suspend fun endRoutine(@Path("routineId") routineId: Int): BaseResponse<Unit>
}
