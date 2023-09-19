package ch.lock.mobile.android.deviceinfo.ui.screen.main.siminfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ch.lock.mobile.android.deviceinfo.ui.base.viewmodel.BaseViewModel
import ch.lock.mobile.android.deviceinfo.utils.SimUtils

class SimInfoViewModel(
    simUtils: SimUtils
) : BaseViewModel() {

    companion object {
        const val TAG = "SimInfoViewModel"
    }

    /**
     * 전화번호
     */
    private val _phoneNumber: MutableLiveData<String> = MutableLiveData(simUtils.phoneNumber)
    val phoneNumber: LiveData<String> = _phoneNumber

    /**
     * 통신사
     */
    private val _telecom: MutableLiveData<String> = MutableLiveData(simUtils.telecom)
    val telecom: LiveData<String> = _telecom

    /**
     * SIM Serial 번호
     */
    private val _simNumber: MutableLiveData<String> = MutableLiveData(simUtils.simNumber)
    val simNumber: LiveData<String> = _simNumber

}