package ch.lock.mobile.android.deviceinfo.ui.setting

import androidx.lifecycle.*
import ch.lock.mobile.android.deviceinfo.data.local.datastore.setting.SettingPrefRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SettingViewModel(
    private val settingPrefRepository: SettingPrefRepository
) : ViewModel() {

    companion object {
        const val TAG: String = "SettingViewModel"
    }

    /**
     * 하이픈 사용 여부
     */
    val isUseHyphen: MutableLiveData<Boolean> =
        (settingPrefRepository.settingPrefFlow.map {
            it.isUseHyphen
        }.asLiveData() as MutableLiveData<Boolean>)

    /**
     * 캡쳐 방지 여부
     */
    val isCaptureBlock: MutableLiveData<Boolean> =
        (settingPrefRepository.settingPrefFlow.map {
            it.isCaptureBlock
        }.asLiveData() as MutableLiveData<Boolean>)

    init {
        viewModelScope.launch {
            launch {
                isUseHyphen.asFlow().collect {
                    settingPrefRepository.updateIsUseHyphen(it)
                }
            }
            launch {
                isCaptureBlock.asFlow().collect {
                    settingPrefRepository.updateIsCaptureBlock(it)
                }
            }
        }
    }

}