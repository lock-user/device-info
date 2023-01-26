package ch.lock.mobile.android.deviceinfo.data.local.datastore.setting

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val SETTING_PREF_NAME: String = "setting_pref"

val Context.dataStore by preferencesDataStore(
    name = SETTING_PREF_NAME
)

data class SettingPref(
    /**
     * 화면 캡쳐 차단 여부
     */
    val isCaptureBlock: Boolean
)

class SettingPrefRepository(
    private val dataStore: DataStore<Preferences>
) {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "SettingPrefRepository"
    }

    private object PrefKeys {
        val IS_CAPTURE_BLOCK = booleanPreferencesKey("IS_CAPTURE_BLOCK")
    }

    val settingPrefFlow: Flow<SettingPref> =
        dataStore.data.map { pref ->
            mapSettingPreferences(pref)
        }

    suspend fun updateIsCaptureBlock(isCaptureBlock: Boolean) = dataStore.edit { pref ->
        pref[PrefKeys.IS_CAPTURE_BLOCK] = isCaptureBlock
    }

    private fun mapSettingPreferences(preferences: Preferences): SettingPref {

        // 화면 캡쳐 차단 여부
        val isCaptureBlock: Boolean = preferences[PrefKeys.IS_CAPTURE_BLOCK] ?: true

        return SettingPref(
            isCaptureBlock = isCaptureBlock
        )
    }

}