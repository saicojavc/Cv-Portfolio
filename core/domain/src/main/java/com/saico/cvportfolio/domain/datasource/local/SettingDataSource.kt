package com.saico.cvportfolio.domain.datasource.local

import com.saico.cvportfolio.model.settings.CVPSystemTheme
import kotlinx.coroutines.flow.Flow

interface SettingDataSource {
    suspend fun setSystemTheme(theme: CVPSystemTheme)
    fun getSystemTheme(): Flow<CVPSystemTheme>

}