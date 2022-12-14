package ch.lock.mobile.android.deviceinfo.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

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
     * @return 안드로이드 OS API Level
     */
    open val apiLevel: String
        get() = Build.VERSION.SDK_INT.toString()

    /**
     * @return 디바이스 IMEI
     */
    open val imei: String
        get() = try {
            telephonyManager.deviceId ?: ""
        } catch (e: Exception) {
            "안드로이드 10부터는 imei를 확인할 수 없습니다."
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
     * @return 커널
     */
    open val kernel: String
        get() = try {
            val command = Runtime.getRuntime().exec("uname -s -m", null, null)
            var inputStream: InputStream? = null

            inputStream = if (command.waitFor() == 0) {
                command.inputStream
            } else {
                command.errorStream
            }

            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream),
                1024
            )
            val line: String = bufferedReader.readLine()
            bufferedReader.close()
            line
        } catch (e: Exception) {
            val abis: Array<String> = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Build.SUPPORTED_ABIS
            } else {
                arrayOf(Build.CPU_ABI, Build.CPU_ABI2)
            }
            var ext = " "
            for (abi in abis) {
                if (TextUtils.equals(abi, "x86_64")) {
                    ext = "amd64"
                    break
                } else if (TextUtils.equals(abi, "x86")) {
                    ext = "x86"
                    break
                } else if (TextUtils.equals(abi, "armeabi-v7a")) {
                    ext = "armeabi-v7a"
                    break
                }
            }
            System.getProperty("os.name") + " " + ext
        }

    /**
     * @return 빌드번호
     */
    open val buildNumber: String
        get() = Build.ID
}

