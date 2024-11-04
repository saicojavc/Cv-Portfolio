package com.saico.cvportfolio.domain.usescases.settings

import com.saico.cvportfolio.domain.repository.KDataStoreRepository
import com.saico.cvportfolio.model.settings.CVPSystemTheme
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSystemThemeUseCase @Inject constructor(
    private val repo: KDataStoreRepository,
) {
    operator fun invoke(): Flow<CVPSystemTheme> = repo.getSystemTheme
}