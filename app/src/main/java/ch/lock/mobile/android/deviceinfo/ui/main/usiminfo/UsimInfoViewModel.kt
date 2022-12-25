package ch.lock.mobile.android.deviceinfo.ui.main.usiminfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.lock.mobile.android.deviceinfo.utils.DeviceUtils

class UsimInfoViewModel(
    deviceUtils: DeviceUtils
) : ViewModel() {

    companion object {
        const val TAG: String = "UsimInfoViewModel"
    }

    /**
     * 전화번호
     */
    private val _phoneNumber: MutableLiveData<String> = MutableLiveData(deviceUtils.phoneNumber)
    val phoneNumber: LiveData<String> = _phoneNumber

    /**
     * 통신사
     */
    private val _telecom: MutableLiveData<String> = MutableLiveData(deviceUtils.telecom)
    val telecom: LiveData<String> = _telecom

    /**
     * USIM Serial 번호
     */
    private val _usimNumber: MutableLiveData<String> = MutableLiveData(deviceUtils.usimNumber)
    val usimNumber: LiveData<String> = _usimNumber

}