package ch.lock.mobile.android.deviceinfo.ui.setting

import androidx.lifecycle.*
import ch.lock.mobile.android.deviceinfo.base.BaseViewModel
import ch.lock.mobile.android.deviceinfo.data.local.datastore.setting.SettingPrefRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SettingViewModel(
    private val settingPrefRepository: SettingPrefRepository
) : BaseViewModel() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "SettingViewModel"
    }

    /**
     * 캡쳐 방지 여부 설정
     */
    val isCaptureBlock: MutableLiveData<Boolean> =
        (settingPrefRepository.settingPrefFlow.map {
            it.isCaptureBlock
        }.asLiveData() as MutableLiveData<Boolean>)

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