package com.myteam.hackathonapp.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class AppsModel(
    val homeTitle: String,
    val homeSubTitle: String
)
