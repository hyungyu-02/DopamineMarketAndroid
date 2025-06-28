package com.myteam.hackathonapp.di

import com.myteam.hackathonapp.data.service.AppsService
import com.myteam.hackathonapp.data.service.UserService
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
    fun provideAppsService(retrofit: Retrofit): AppsService =
        retrofit.create(AppsService::class.java)

    // 🔥 요거 추가!
    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}