package com.myteam.hackathonapp.data.repositoryimpl

import com.myteam.hackathonapp.data.dto.request.LoginRequestDto
import com.myteam.hackathonapp.data.dto.response.LoginResponseDto
import com.myteam.hackathonapp.data.service.UserService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) {
    suspend fun loginUser(request: LoginRequestDto): Result<LoginResponseDto> {
        return try {
            val response = userService.loginUser(request)
            if (response.success && response.code == 20000) {
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message)) // 예: "비밀번호가 올바르지 않습니다"
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}