package com.saico.cvportfolio.domain.repository

import com.saico.cvportfolio.model.settings.CVPSystemTheme
import kotlinx.coroutines.flow.Flow

interface KDataStoreRepository {

    val getSystemTheme: Flow<CVPSystemTheme>
    suspend fun setSystemTheme(theme: CVPSystemTheme)
}