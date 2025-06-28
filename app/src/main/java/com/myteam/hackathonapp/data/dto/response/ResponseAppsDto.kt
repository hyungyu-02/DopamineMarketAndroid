package com.myteam.hackathonapp.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAppsDto(
    val appId: Int,
    val appName: String,
    val url: String,
    val coinRequired: Int,
    val isLocked: Boolean
)