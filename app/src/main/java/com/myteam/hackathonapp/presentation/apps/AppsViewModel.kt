package com.myteam.hackathonapp.presentation.apps

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myteam.hackathonapp.data.dto.request.RegisterAppRequestDto
import com.myteam.hackathonapp.domain.entity.AppsModel
import com.myteam.hackathonapp.domain.repository.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppsViewModel @Inject constructor(
    private val appsRepository: AppsRepository
) : ViewModel() {

    var apps by mutableStateOf<List<AppsModel>>(emptyList())
        private set

    fun getAppsData(userId: Int) {
        Log.d("AppsViewModel", "getAppsData 호출됨 - userId: $userId")
        viewModelScope.launch {
            appsRepository.getAppsData(userId)
                .onSuccess {
                    apps = it
                    Log.d("AppsViewModel", "앱 목록 로딩 성공 - 개수: ${it.size}")
                }
                .onFailure {
                    Log.e("AppsViewModel", "앱 목록 로딩 실패", it)
                }
        }
    }

    fun registerApp(request: RegisterAppRequestDto) {
        Log.d("AppsViewModel", "registerApp 호출됨 - request: $request")
        viewModelScope.launch {
            appsRepository.registerApp(request)
                .onSuccess {
                    Log.d("AppsViewModel", "앱 등록 성공 - 다시 앱 목록 불러오기")
                    getAppsData(request.userId)
                }
                .onFailure {
                    Log.e("AppsViewModel", "앱 등록 실패", it)
                }
        }
    }
}