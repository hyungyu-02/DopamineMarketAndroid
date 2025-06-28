package com.myteam.hackathonapp.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class AppsModel(
    val appId: Int,
    val appName: String,
    val url: String,
    val coinRequired: Int,
    val isLocked: Boolean
)
