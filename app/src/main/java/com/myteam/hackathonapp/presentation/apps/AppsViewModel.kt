package com.myteam.hackathonapp.presentation.apps

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
        viewModelScope.launch {
            appsRepository.getAppsData(userId)
                .onSuccess { apps = it }
                .onFailure { /* TODO: 에러 처리 */ }
        }
    }

    fun registerApp(request: RegisterAppRequestDto) {
        viewModelScope.launch {
            appsRepository.registerApp(request)
                .onSuccess { getAppsData(request.userId) }
                .onFailure { /* TODO: 에러 처리 */ }
        }
    }
}