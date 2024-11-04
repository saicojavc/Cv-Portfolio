package com.saico.cvportfolio.domain.usescases.settings

import com.saico.cvportfolio.domain.repository.KDataStoreRepository
import com.saico.cvportfolio.model.settings.CVPSystemTheme
import javax.inject.Inject

class SetSystemThemeUseCase @Inject constructor(
    private val repo: KDataStoreRepository,
) {
    suspend operator fun invoke(theme: CVPSystemTheme) = repo.setSystemTheme(theme)
}