package ch.lock.mobile.android.deviceinfo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi

@SuppressLint("MissingPermission", "HardwareIds")
open class SimUtils(
    private val applicationContext: Context
) {

    companion object {
        const val TAG: String = "SimUtils"
    }

    private val telephonyManager: TelephonyManager by lazy {
        applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    private val subscriptionManager: SubscriptionManager
        @RequiresApi(value = Build.VERSION_CODES.LOLLIPOP_MR1)
        get() = applicationContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

    /**
     * @return 디바이스 SIM Serial Number
     */
    open val simNumber: String
        get() = try {
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1 ->
                    subscriptionManager.activeSubscriptionInfoList?.firstOrNull()?.iccId ?: "유심이 장착되어 있지 않습니다."
                else -> telephonyManager.simSerialNumber ?: ""
            }
        } catch (e: Exception) {
            ""
        }

    /**
     * @return 통신사 정보
     */
    open val telecom: String
        get() = try {
            telephonyManager.networkOperatorName ?: ""
        } catch (e: Exception) {
            ""
        }

    /**
     * @return 디바이스 전화번호
     */
    open val phoneNumber: String
        get() = try {
            telephonyManager.line1Number ?: ""
        } catch (e: Exception) {
            ""
        }

}