package com.myteam.hackathonapp.domain.repository

import com.myteam.hackathonapp.data.dto.request.LoginRequestDto
import com.myteam.hackathonapp.data.dto.response.LoginResponseDto

interface UserRepository {
    suspend fun loginUser(request: LoginRequestDto): Result<LoginResponseDto>
}