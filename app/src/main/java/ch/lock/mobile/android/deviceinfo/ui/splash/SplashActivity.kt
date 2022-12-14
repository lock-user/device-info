package ch.lock.mobile.android.deviceinfo.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivitySplashBinding
import ch.lock.mobile.android.deviceinfo.utils.ActivityUtils
import ch.lock.mobile.android.deviceinfo.utils.PermissionUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseCompatActivity<ActivitySplashBinding>() {

    companion object {
        const val TAG: String = "SplashActivity"
    }

    private val permissionUtils: PermissionUtils by inject()

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPermission()
    }

    /**
     * 권한 초기화
     */
    private fun initPermission() = CoroutineScope(Dispatchers.Main).launch {
        permissionUtils.checkPermission(this@SplashActivity) {
            ActivityUtils.getInstance().startMainActivity(this@SplashActivity)
        }
    }

}