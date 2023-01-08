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
     * 전화번호에 하이픈 표시 여부
     */
    val isUseHyphen: Boolean,

    /**
     * 화면 캡쳐 차단 여부
     */
    val isCaptureBlock: Boolean
)

class SettingPrefRepository(
    private val dataStore: DataStore<Preferences>
) {

    companion object {
        const val TAG: String = "SettingPrefRepository"
    }

    object PrefKeys {
        val IS_USE_HYPHEN = booleanPreferencesKey("IS_USE_HYPHEN")
        val IS_CAPTURE_BLOCK = booleanPreferencesKey("IS_CAPTURE_BLOCK")
    }

    val settingPrefFlow: Flow<SettingPref> =
        dataStore.data.map { pref ->
            mapSettingPreferences(pref)
        }

    suspend fun updateIsUseHyphen(isUseHyphen: Boolean) = dataStore.edit { pref ->
        pref[PrefKeys.IS_USE_HYPHEN] = isUseHyphen
    }

    suspend fun updateIsCaptureBlock(isCaptureBlock: Boolean) = dataStore.edit { pref ->
        pref[PrefKeys.IS_CAPTURE_BLOCK] = isCaptureBlock
    }

    private fun mapSettingPreferences(preferences: Preferences): SettingPref {
        // 하이픈 사용 여부
        val isUseHyphen: Boolean = preferences[PrefKeys.IS_USE_HYPHEN] ?: false

        // 화면 캡쳐 차단 여부
        val isCaptureBlock: Boolean = preferences[PrefKeys.IS_CAPTURE_BLOCK] ?: false

        return SettingPref(
            isUseHyphen = isUseHyphen,
            isCaptureBlock = isCaptureBlock
        )
    }

}