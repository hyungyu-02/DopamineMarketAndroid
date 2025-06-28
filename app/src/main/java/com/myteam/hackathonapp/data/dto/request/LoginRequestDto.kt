package com.myteam.hackathonapp.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val nickname: String,
    val password: String
)
