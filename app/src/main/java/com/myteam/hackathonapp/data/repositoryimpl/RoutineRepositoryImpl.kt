package com.myteam.hackathonapp.data.repositoryimpl

import com.myteam.hackathonapp.data.dto.request.RoutineRequestDto
import com.myteam.hackathonapp.data.dto.response.BaseResponse
import com.myteam.hackathonapp.data.dto.response.RoutineListResponseDto
import com.myteam.hackathonapp.data.dto.response.RoutineRequestResponseDto
import com.myteam.hackathonapp.data.service.RoutineService
import com.myteam.hackathonapp.presentation.routines.data.RoutineRepository
import javax.inject.Inject

//class RoutineRepositoryImpl @Inject constructor(
//    // 필요 시 의존성 주입
//) : RoutineRepository {
//    override fun getRoutines(): List<String> {
//        return listOf("헬스", "공부", "휴식")
//    }
//}

class RoutineRepositoryImpl @Inject constructor(
    private val service: RoutineService
) : RoutineRepository {
    override fun getRoutines(): List<String> {
        return TODO("Provide the return value")
    }

    override suspend fun registerRoutine(request: RoutineRequestDto): Result<BaseResponse<RoutineRequestResponseDto>> {
        return runCatching { service.registerRoutine(request) }
    }

    override suspend fun getRoutineList(userId: Int): Result<BaseResponse<RoutineListResponseDto>> {
        return runCatching { service.getRoutineList(userId) }
    }

    override suspend fun deleteRoutine(routineId: Int): Result<BaseResponse<Unit>> {
        return runCatching { service.deleteRoutine(routineId) }
    }

    override suspend fun endRoutine(routineId: Int): Result<BaseResponse<Unit>> {
        return runCatching { service.endRoutine(routineId) }
    }
}