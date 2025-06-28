package com.myteam.hackathonapp.data.repositoryimpl

import com.myteam.hackathonapp.data.mapper.toAppsModel
import com.myteam.hackathonapp.data.service.AppsService
import com.myteam.hackathonapp.domain.entity.AppsModel
import com.myteam.hackathonapp.domain.repository.AppsRepository
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor(
    private val appsService: AppsService
) : AppsRepository {
    override suspend fun getAppsData(request: Int): Result<AppsModel> =
        runCatching {
            val response = appsService.getAppsData(request)
            response.data.toAppsModel()
        }

}