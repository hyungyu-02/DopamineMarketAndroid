package com.myteam.hackathonapp.data.mapper

import com.myteam.hackathonapp.data.dto.response.ResponseAppsDto
import com.myteam.hackathonapp.domain.entity.AppsModel

fun ResponseAppsDto.toAppsModel() = AppsModel(
    appId = appId,
    appName = appName,
    url = url,
    coinRequired = coinRequired,
    isLocked = isLocked
)