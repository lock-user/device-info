package ch.lock.mobile.android.deviceinfo.ui.screen.setting

import androidx.lifecycle.*
import ch.lock.mobile.android.deviceinfo.BuildConfig
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.viewmodel.BaseViewModel
import ch.lock.mobile.android.deviceinfo.data.local.datastore.setting.SettingPrefRepository
import ch.lock.mobile.android.deviceinfo.utils.DeviceUtils
import ch.lock.mobile.android.deviceinfo.utils.ResourceProvider
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SettingViewModel(
    resourceProvider: ResourceProvider,
    private val settingPrefRepository: SettingPrefRepository
) : BaseViewModel() {

    companion object {
        const val TAG: String = "SettingViewModel"
    }

    /**
     * 캡쳐 방지 여부 설정
     */
    val isCaptureBlock: MutableLiveData<Boolean> =
        (settingPrefRepository.settingPrefFlow.map {
            it.isCaptureBlock
        }.asLiveData() as MutableLiveData<Boolean>)

    /**
     * 앱 버전
     */
    val versionName: LiveData<String> =
        MutableLiveData("${resourceProvider.getString(R.string.version)}: ${BuildConfig.VERSION_NAME}")

    init {
        viewModelScope.launch {
            launch {
                isCaptureBlock.asFlow().collect {
                    settingPrefRepository.updateIsCaptureBlock(it)
                }
            }
        }
    }

}