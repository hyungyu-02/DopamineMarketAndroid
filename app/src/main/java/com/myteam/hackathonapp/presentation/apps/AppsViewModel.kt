package com.myteam.hackathonapp.presentation.apps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myteam.hackathonapp.domain.repository.AppsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppsViewModel @Inject constructor(
    private val appsRepository: AppsRepository
) : ViewModel() {
    fun getAppsData(
        request: Int
    ) {
        viewModelScope.launch {
            appsRepository.getAppsData(request)
                .onSuccess {

                }
                .onFailure {

                }
        }
    }
}