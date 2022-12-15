package ch.lock.mobile.android.deviceinfo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.lock.mobile.android.deviceinfo.utils.DeviceUtils

class MainViewModel(
    deviceUtils: DeviceUtils
) : ViewModel() {

    companion object {
        const val TAG: String = "MainViewModel"
    }

    /**
     * 전화번호
     */
    private val _phoneNumber: MutableLiveData<String> = MutableLiveData(deviceUtils.phoneNumber)
    val phoneNumber: LiveData<String> = _phoneNumber

}