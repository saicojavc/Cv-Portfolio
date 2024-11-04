package com.saico.cvportfolio.domain.di

import com.saico.cvportfolio.domain.data.KDataStoreRepoImpl
import com.saico.cvportfolio.domain.repository.KDataStoreRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {
    @Singleton
    @Binds
    fun bindsKDataStoreRepository(impl: KDataStoreRepoImpl): KDataStoreRepository
}