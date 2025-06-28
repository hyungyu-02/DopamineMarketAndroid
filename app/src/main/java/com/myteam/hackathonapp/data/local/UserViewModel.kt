package com.myteam.hackathonapp.data.local

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myteam.hackathonapp.data.dto.request.LoginRequestDto
import com.myteam.hackathonapp.data.dto.response.LoginResponseDto
import com.myteam.hackathonapp.data.repositoryimpl.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepositoryImpl
) : ViewModel() {

    var loginState by mutableStateOf<LoginResponseDto?>(null)
        private set

    fun login(nickname: String, password: String) {
        viewModelScope.launch {
            val result = userRepository.loginUser(LoginRequestDto(nickname, password))
            result.onSuccess {
                loginState = it
                UserSession.userId = it.user_id // 🔥 핵심
            }.onFailure {
                // TODO: 실패 처리
            }
        }
    }
}

object UserSession {
    var userId: Int? = null
}