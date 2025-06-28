package com.myteam.hackathonapp.data.dto.response

import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class RoutineRequestResponseDto(
    val routineId: Int
)

@kotlinx.serialization.Serializable
data class RoutineListResponseDto(
    val fixedRoutines: List<RoutineItemDto>,
    val todayRoutines: List<RoutineItemDto>
)

@Serializable
data class RoutineItemDto(
    val routineId: Int,
    val title: String,
    val category: String,
    val timer: Int,
    val isDaily: Boolean,
    val completed: Boolean,
    val startTime: String
)