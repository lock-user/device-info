package ch.lock.mobile.android.deviceinfo.ui.screen.main.deviceinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.lock.mobile.android.deviceinfo.ui.base.viewmodel.BaseViewModel
import ch.lock.mobile.android.deviceinfo.utils.DeviceUtils

class DeviceInfoViewModel(
    deviceUtils: DeviceUtils
) : BaseViewModel() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "DeviceInfoViewModel"
    }

    /**
     * 디바이스 브랜드
     */
    private val _deviceBrand: MutableLiveData<String> = MutableLiveData(deviceUtils.brand)
    val deviceBrand: LiveData<String> = _deviceBrand

    /**
     * 디바이스 모델
     */
    private val _deviceModel: MutableLiveData<String> = MutableLiveData(deviceUtils.model)
    val deviceModel: LiveData<String> = _deviceModel

    /**
     * 안드로이드 버전
     */
    private val _androidVersion: MutableLiveData<String> = MutableLiveData(deviceUtils.os)
    val androidVersion: LiveData<String> = _androidVersion

    /**
     * 안드로이드 SDK 버전
     */
    private val _androidApiLevel: MutableLiveData<String> = MutableLiveData(deviceUtils.apiLevel)
    val androidApiLevel: LiveData<String> = _androidApiLevel

    /**
     * 안드로이드 id
     */
    private val _androidId: MutableLiveData<String> = MutableLiveData(deviceUtils.androidId)
    val androidId: LiveData<String> = _androidId

    /**
     * imei
     */
    private val _imei: MutableLiveData<String> = MutableLiveData(deviceUtils.imei)
    val imei: LiveData<String> = _imei

    /**
     * kernel
     */
    private val _kernel: MutableLiveData<String> = MutableLiveData(deviceUtils.kernel)
    val kernel: LiveData<String> = _kernel

    /**
     * build number
     */
    private val _buildNumber: MutableLiveData<String> = MutableLiveData(deviceUtils.buildNumber)
    val buildNumber: LiveData<String> = _buildNumber

}