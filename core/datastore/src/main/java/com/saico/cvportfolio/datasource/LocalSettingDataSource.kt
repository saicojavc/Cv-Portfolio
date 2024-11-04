package com.saico.cvportfolio.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.saico.cvportfolio.domain.datasource.local.SettingDataSource
import com.saico.cvportfolio.model.settings.CVPSystemTheme
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalSettingDataSource @Inject constructor(@ApplicationContext val context: Context) :
    SettingDataSource {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings_preference")

    private object Keys {
        val THEME = stringPreferencesKey("theme_key")
    }

    override suspend fun setSystemTheme(theme: CVPSystemTheme) {
        context.dataStore.edit {
            it[Keys.THEME] = theme.toString()
        }
    }

    override fun getSystemTheme(): Flow<CVPSystemTheme> =
        context.dataStore.data.map { preferences ->
            preferences[Keys.THEME]?.let { CVPSystemTheme.valueOf(it) }
                ?: CVPSystemTheme.System
        }
}
