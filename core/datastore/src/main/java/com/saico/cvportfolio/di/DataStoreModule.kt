package com.saico.cvportfolio.di

import com.saico.cvportfolio.datasource.LocalSettingDataSource
import com.saico.cvportfolio.domain.datasource.local.SettingDataSource


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataStoreModule {

    @Singleton
    @Binds
    fun bindSettingDataSource(impl: LocalSettingDataSource): SettingDataSource

}


