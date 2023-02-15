package ch.lock.mobile.android.deviceinfo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi

@SuppressLint("MissingPermission", "HardwareIds", "ObsoleteSdkInt")
class SimUtils(
    private val applicationContext: Context,
    private val formatUtils: FormatUtils
) {

    companion object {
        /**
         * TAG
         */
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
    val simNumber: String
        get() = try {
            when (Build.VERSION.SDK_INT) {
                in 1.. 21 -> telephonyManager.simSerialNumber ?: ""
                in 22..28 -> subscriptionManager.activeSubscriptionInfoList?.firstOrNull()?.iccId
                    ?: "유심이 장착되어 있지 않아 확인 불가"
                else -> "안드로이드 정책에 의해 확인 불가"
            }
        } catch (e: Exception) {
            ""
        }

    /**
     * @return 통신사 정보
     */
    val telecom: String
        get() = try {
            telephonyManager.networkOperatorName ?: ""
        } catch (e: Exception) {
            ""
        }

    /**
     * 지역 번호
     *
     * @return 디바이스 전화번호
     */
    val phoneNumber: String
        get() = try {
            formatUtils.toLocalPhoneNumber(globalPhoneNumber)
        } catch (e: Exception) {
            ""
        }

    /**
     * 국제 번호
     *
     * @return 디바이스 전화번호
     */
    val globalPhoneNumber: String
        get() = try {
            telephonyManager.line1Number ?: ""
        } catch (e: Exception) {
            ""
        }

}