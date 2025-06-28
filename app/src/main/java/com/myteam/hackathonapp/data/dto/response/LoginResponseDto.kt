package com.myteam.hackathonapp.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val user_id: Int,
    val nickname: String
)
