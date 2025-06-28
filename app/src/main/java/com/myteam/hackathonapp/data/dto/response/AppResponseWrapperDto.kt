package com.myteam.hackathonapp.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AppsResponseWrapperDto(
    val apps: List<ResponseAppsDto>
)