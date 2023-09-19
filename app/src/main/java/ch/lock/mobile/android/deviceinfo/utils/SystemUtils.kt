package ch.lock.mobile.android.deviceinfo.utils

import android.os.SystemClock

class SystemUtils {

    companion object {
        const val TAG = "SystemUtils"
    }

    /**
     * @return 디바이스의 마지막 부팅 시간
     */
    val lastBootTime: String
        get() = SystemClock.elapsedRealtime().getTime()

}