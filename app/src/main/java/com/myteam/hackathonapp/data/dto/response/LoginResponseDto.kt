package com.myteam.hackathonapp.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    @SerialName("userId")
    val user_id: Int,
    val nickname: String
)
