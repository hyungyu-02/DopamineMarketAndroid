package com.myteam.hackathonapp.data.dto.response

data class BaseResponse<T>(
    val code: Int,
    val data: T,
    val message: String
)
