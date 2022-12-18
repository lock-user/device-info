package ch.lock.mobile.android.deviceinfo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi

@SuppressLint("MissingPermission", "HardwareIds")
open class DeviceUtils(
    private val applicationContext: Context
) {

    companion object {
        const val TAG = "DeviceUtil"
    }

    private val telephonyManager: TelephonyManager by lazy {
        applicationContext.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    private val subscriptionManager: SubscriptionManager
        @RequiresApi(value = Build.VERSION_CODES.LOLLIPOP_MR1)
        get() = applicationContext.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE) as SubscriptionManager

    /**
     * @return 디바이스 모델
     */
    open val model: String
        get() = Build.MODEL

    /**
     * @return 디바이스 브랜드
     */
    open val brand: String
        get() = Build.BRAND

    /**
     * @return OS Version
     */
    open val os: String
        get() = Build.VERSION.RELEASE

    /**
     * @return 디바이스 IMEI
     */
    open val imei: String
        get() = try {
            telephonyManager.deviceId ?: ""
        } catch (e: Exception) {
            ""
        }

    /**
     * @return 디바이스 USIM Serial Number
     */
    open val usimNumber: String
        get() = try {
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1 ->
                    subscriptionManager.activeSubscriptionInfoList?.firstOrNull()?.iccId ?: ""

                else -> telephonyManager.simSerialNumber ?: ""
            }
        } catch (e: Exception) {
            ""
        }

    /**
     * 안드로이드 ~7: 영구 유지
     * 안드로이드 8~: 공장 초기화하면 재설정
     * @return Android ID
     */
    open val androidId: String
        get() = Settings.Secure.getString(
            applicationContext.contentResolver, Settings.Secure.ANDROID_ID
        )

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