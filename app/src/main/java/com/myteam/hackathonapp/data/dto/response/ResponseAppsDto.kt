package com.myteam.hackathonapp.data.dto.response

data class ResponseAppsDto(
    val appId: Int,
    val appName: String,
    val url: String,
    val coinRequired: Int,
    val isLocked: Boolean
)