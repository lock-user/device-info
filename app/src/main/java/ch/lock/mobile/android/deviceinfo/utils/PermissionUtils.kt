package ch.lock.mobile.android.deviceinfo.utils

import android.Manifest
import androidx.lifecycle.LifecycleOwner
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.utils.extension.lifeCycleContext
import com.gun0912.tedpermission.coroutine.TedPermission

class PermissionUtils {

    companion object {
        const val TAG: String = "PermissionUtils"
    }

    /**
     * 권한 부여 여부 확인 및 요청
     */
    suspend fun checkPermission(lifecycleOwner: LifecycleOwner, onGranted: () -> Unit) {
        val permissionResult = TedPermission.create().setPermissions(
            Manifest.permission.READ_PHONE_STATE
        )
            .setDeniedMessage(lifecycleOwner.lifeCycleContext.getString(R.string.permission_denied_message))
            .setDeniedCloseButtonText(lifecycleOwner.lifeCycleContext.getString(R.string.close))
            .setGotoSettingButton(true)
            .setGotoSettingButtonText(lifecycleOwner.lifeCycleContext.getString(R.string.setting))
            .check()

        if (permissionResult.isGranted) {
            onGranted()
        } else {
            checkPermission(lifecycleOwner, onGranted)
        }
    }

}