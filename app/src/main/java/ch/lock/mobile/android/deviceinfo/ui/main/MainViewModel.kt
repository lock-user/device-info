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

    /**
     * 통신사
     */
    private val _telecom: MutableLiveData<String> = MutableLiveData(deviceUtils.telecom)
    val telecom: LiveData<String> = _telecom

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
     * USIM Serial 번호
     */
    private val _usimNumber: MutableLiveData<String> = MutableLiveData(deviceUtils.usimNumber)
    val usimNumber: LiveData<String> = _usimNumber

}