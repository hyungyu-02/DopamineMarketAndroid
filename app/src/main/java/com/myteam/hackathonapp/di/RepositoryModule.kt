package com.myteam.hackathonapp.di

import com.myteam.hackathonapp.data.repositoryimpl.AppsRepositoryImpl
import com.myteam.hackathonapp.domain.repository.AppsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsAppsRepository(homeRepositoryImpl: AppsRepositoryImpl): AppsRepository
}