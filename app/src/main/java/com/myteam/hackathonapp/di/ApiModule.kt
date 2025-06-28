package com.myteam.hackathonapp.di

import com.myteam.hackathonapp.data.service.AppsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun providesAppsService(retrofit: Retrofit): AppsService =
        retrofit.create(AppsService::class.java)
}