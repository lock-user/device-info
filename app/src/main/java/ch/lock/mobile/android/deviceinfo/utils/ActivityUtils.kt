package ch.lock.mobile.android.deviceinfo.utils

import android.app.Activity
import android.content.Intent
import ch.lock.mobile.android.deviceinfo.ui.main.MainActivity
import ch.lock.mobile.android.deviceinfo.ui.main.deviceinfo.DeviceInfoActivity

class ActivityUtils {

    /**
     * MainActivity로 이동
     */
    fun startMainActivity(activity: Activity) {
        Intent(activity, MainActivity::class.java).let {
            activity.startActivity(it)
        }
    }

    /**
     * DeviceInfoActivity로 이동
     */
    fun startDeviceInfoActivity(activity: Activity) {
        Intent(activity, DeviceInfoActivity::class.java).let {
            activity.startActivity(it)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ActivityUtils? = null

        @JvmStatic
        fun getInstance(): ActivityUtils = INSTANCE ?: synchronized(this) {
            INSTANCE ?: ActivityUtils().also {
                INSTANCE = it
            }
        }
    }

}