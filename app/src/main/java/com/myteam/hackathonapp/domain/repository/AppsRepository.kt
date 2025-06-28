package com.myteam.hackathonapp.domain.repository

import com.myteam.hackathonapp.domain.entity.AppsModel

interface AppsRepository {
    suspend fun getAppsData(request: Int): Result<AppsModel>
}