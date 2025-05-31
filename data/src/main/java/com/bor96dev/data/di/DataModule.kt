package com.bor96dev.data.di

import com.bor96dev.data.RepositoryImpl
import com.bor96dev.domain.VacancyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {


    @Binds
    @Singleton
    abstract fun bindVacancyRepository(
        repositoryImpl: RepositoryImpl
    ): VacancyRepository

}