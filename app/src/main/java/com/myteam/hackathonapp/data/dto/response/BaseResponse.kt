package com.myteam.hackathonapp.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val success: Boolean,
    val code: Int,
    val data: T,
    val message: String
)
