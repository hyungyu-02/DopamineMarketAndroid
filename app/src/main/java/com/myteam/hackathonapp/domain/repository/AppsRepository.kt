package com.myteam.hackathonapp.domain.repository

import com.myteam.hackathonapp.data.dto.request.RegisterAppRequestDto
import com.myteam.hackathonapp.domain.entity.AppsModel

interface AppsRepository {
    suspend fun getAppsData(userId: Int): Result<List<AppsModel>>
    suspend fun registerApp(request: RegisterAppRequestDto): Result<AppsModel>
}