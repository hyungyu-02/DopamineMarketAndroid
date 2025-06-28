package com.myteam.hackathonapp.data.repositoryimpl

import com.myteam.hackathonapp.data.dto.request.RegisterAppRequestDto
import com.myteam.hackathonapp.data.mapper.toAppsModel
import com.myteam.hackathonapp.data.service.AppsService
import com.myteam.hackathonapp.domain.entity.AppsModel
import com.myteam.hackathonapp.domain.repository.AppsRepository
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor(
    private val appsService: AppsService
) : AppsRepository {

    override suspend fun getAppsData(userId: Int): Result<List<AppsModel>> =
        runCatching {
            val response = appsService.getAppsData(userId)
            response.data.apps.map { it.toAppsModel() }
        }

    override suspend fun registerApp(request: RegisterAppRequestDto): Result<AppsModel> {
        TODO("Not yet implemented")
    }
}