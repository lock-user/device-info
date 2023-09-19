package ch.lock.mobile.android.deviceinfo.ui.screen.main.system

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.lock.mobile.android.deviceinfo.ui.base.viewmodel.BaseViewModel
import ch.lock.mobile.android.deviceinfo.utils.SystemUtils

class SystemViewModel(
    systemUtils: SystemUtils
) : BaseViewModel() {

    companion object {
        const val TAG = "SystemViewModel"
    }

    /**
     * 마지막 부팅 시간
     */
    private val _lastBootTime: MutableLiveData<String> = MutableLiveData(systemUtils.lastBootTime)
    val lastBootTime: LiveData<String> = _lastBootTime

}