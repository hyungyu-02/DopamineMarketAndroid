package com.myteam.hackathonapp.presentation.routines.data

import com.myteam.hackathonapp.data.dto.request.RoutineRequestDto
import com.myteam.hackathonapp.data.dto.response.BaseResponse
import com.myteam.hackathonapp.data.dto.response.RoutineListResponseDto
import com.myteam.hackathonapp.data.dto.response.RoutineRequestResponseDto

interface RoutineRepository {
    fun getRoutines(): List<String>
    suspend fun registerRoutine(request: RoutineRequestDto): Result<BaseResponse<RoutineRequestResponseDto>>
    suspend fun getRoutineList(userId: Int): Result<BaseResponse<RoutineListResponseDto>>
    suspend fun deleteRoutine(routineId: Int): Result<BaseResponse<Unit>>
    suspend fun endRoutine(routineId: Int): Result<BaseResponse<Unit>>
}