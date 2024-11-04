package com.saico.cvportfolio.domain.di

import com.saico.cvportfolio.domain.repository.KDataStoreRepository
import com.saico.cvportfolio.domain.usescases.settings.GetSystemThemeUseCase
import com.saico.cvportfolio.domain.usescases.settings.SetSystemThemeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
@Suppress("TooManyFunctions")
object UsesCaseModule {

    @Singleton
    @Provides
    fun provideGetSystemThemeUseCase(repo: KDataStoreRepository): GetSystemThemeUseCase =
        GetSystemThemeUseCase(repo = repo)

    @Singleton
    @Provides
    fun provideSetSystemThemeUseCase(repo: KDataStoreRepository): SetSystemThemeUseCase =
        SetSystemThemeUseCase(repo = repo)
}