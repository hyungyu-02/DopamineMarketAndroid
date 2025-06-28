package com.myteam.hackathonapp.di

import com.myteam.hackathonapp.data.repositoryimpl.RoutineRepositoryImpl
import com.myteam.hackathonapp.presentation.routines.data.RoutineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RoutineRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRoutineRepository(
        impl: RoutineRepositoryImpl
    ): RoutineRepository
}