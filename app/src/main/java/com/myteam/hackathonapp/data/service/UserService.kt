package com.myteam.hackathonapp.data.service

import com.myteam.hackathonapp.data.dto.request.LoginRequestDto
import com.myteam.hackathonapp.data.dto.response.BaseResponse
import com.myteam.hackathonapp.data.dto.response.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/users")
    suspend fun loginUser(
        @Body loginRequestDto: LoginRequestDto
    ): BaseResponse<LoginResponseDto>
}