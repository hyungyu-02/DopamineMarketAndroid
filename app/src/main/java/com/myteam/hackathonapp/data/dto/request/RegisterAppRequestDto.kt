package com.myteam.hackathonapp.data.dto.request

data class RegisterAppRequestDto(
    val userId: Int,
    val appName: String,
    val url: String
)