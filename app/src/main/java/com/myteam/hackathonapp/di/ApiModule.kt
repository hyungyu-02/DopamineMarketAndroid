package com.myteam.hackathonapp.di

import com.myteam.hackathonapp.data.service.AppsService
import com.myteam.hackathonapp.data.service.RoutineService
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

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    // ✅ 추가 필요!
    @Provides
    @Singleton
    fun provideRoutineService(retrofit: Retrofit): RoutineService =
        retrofit.create(RoutineService::class.java)
}