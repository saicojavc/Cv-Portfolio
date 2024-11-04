package com.saico.cvportfolio.domain.data

import com.saico.cvportfolio.domain.datasource.local.SettingDataSource
import com.saico.cvportfolio.domain.repository.KDataStoreRepository
import com.saico.cvportfolio.model.settings.CVPSystemTheme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class KDataStoreRepoImpl @Inject constructor(
    private val settingDataSource: SettingDataSource,
) : KDataStoreRepository {

    override val getSystemTheme: Flow<CVPSystemTheme> =
        settingDataSource.getSystemTheme()


    override suspend fun setSystemTheme(theme: CVPSystemTheme) =
        settingDataSource.setSystemTheme(theme)

}
