package com.myteam.hackathonapp.presentation.routines.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myteam.hackathonapp.data.dto.request.RoutineRequestDto
import com.myteam.hackathonapp.data.dto.response.RoutineItemDto
import com.myteam.hackathonapp.presentation.routines.data.RoutineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(
    private val repository: RoutineRepository
) : ViewModel() {

    // 현재 루틴 리스트 (fixed + today 합쳐서 관리할지, 분리할지 선택 가능)
    var fixedRoutines = mutableStateListOf<RoutineItemDto>()
        private set

    var todayRoutines = mutableStateListOf<RoutineItemDto>()
        private set

    // 로딩 및 에러 상태 관리
    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    /**
     * 루틴 목록 불러오기
     */
    fun loadRoutines(userId: Int) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null

            repository.getRoutineList(userId)
                .onSuccess { response ->
                    if (response.success) {
                        fixedRoutines.clear()
                        todayRoutines.clear()
                        response.data?.fixedRoutines?.let { fixedRoutines.addAll(it) }
                        response.data?.todayRoutines?.let { todayRoutines.addAll(it) }
                    } else {
                        errorMessage = response.message
                    }
                }
                .onFailure {
                    errorMessage = it.localizedMessage
                }

            isLoading = false
        }
    }

    /**
     * 루틴 등록
     */
    fun addRoutine(
        userId: Int,
        title: String,
        category: String,
        timer: Int,
        isDaily: Boolean,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            val request = RoutineRequestDto(userId, title, category, timer, isDaily)
            repository.registerRoutine(request)
                .onSuccess { response ->
                    if (response.success) {
                        loadRoutines(userId)  // ✅ 저장 후 리스트 새로고침
                        onSuccess()
                    } else {
                        onError(response.message)
                    }
                }
                .onFailure {
                    onError(it.localizedMessage ?: "네트워크 오류")
                }
        }
    }

    /**
     * 루틴 삭제
     */
    fun deleteRoutine(
        userId: Int,
        routineId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            repository.deleteRoutine(routineId)
                .onSuccess { response ->
                    if (response.success) {
                        onSuccess()
                        // 삭제 후 목록 새로고침
                        loadRoutines(userId)
                    } else {
                        onError(response.message)
                    }
                }
                .onFailure {
                    onError(it.localizedMessage ?: "네트워크 오류")
                }
        }
    }

}
