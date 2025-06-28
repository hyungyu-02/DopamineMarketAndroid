package com.myteam.hackathonapp.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class RoutineRequestDto(
    val userId: Int,
    val title: String,
    val category: String,
    val timer: Int,
    val isDaily: Boolean
)
