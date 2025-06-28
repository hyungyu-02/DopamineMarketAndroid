package com.myteam.hackathonapp.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myteam.hackathonapp.data.dto.request.LoginRequestDto
import com.myteam.hackathonapp.data.local.UserSession
import com.myteam.hackathonapp.data.repositoryimpl.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepositoryImpl
) : ViewModel() {

    var loginState by mutableStateOf<Boolean>(false)
        private set

    fun login(nickname: String, password: String, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            val result = userRepository.loginUser(LoginRequestDto(nickname, password))
            result.onSuccess { response ->
                Log.d("LoginViewModel", "로그인 성공! userId: ${response.user_id}, nickname: ${response.nickname}")
                UserSession.userId = response.user_id
                loginState = true
                onSuccess()
            }.onFailure { e ->
                Log.e("LoginViewModel", "로그인 실패: ${e.message}")
                onFailure()
            }
        }
    }
}