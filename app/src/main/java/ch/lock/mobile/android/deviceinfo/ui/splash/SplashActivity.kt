package ch.lock.mobile.android.deviceinfo.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivitySplashBinding
import ch.lock.mobile.android.deviceinfo.ui.main.MainActivity
import ch.lock.mobile.android.deviceinfo.ui.setting.SettingViewModel
import ch.lock.mobile.android.deviceinfo.utils.PermissionUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseCompatActivity<ActivitySplashBinding>() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "SplashActivity"
    }

    private val permissionUtils: PermissionUtils by inject()

    private val settingViewModel: SettingViewModel by viewModel()

    override val isScreenCaptureBlock: Boolean
        get() = initScreenCaptureBlock()

    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPermission()
    }

    /**
     * 뒤로가기 버튼 비활성화
     */
    override fun onBackPressed() {
        //super.onBackPressed()
    }

    private fun initScreenCaptureBlock(): Boolean = settingViewModel.isCaptureBlock.value == true

    /**
     * 권한 초기화
     */
    private fun initPermission() = CoroutineScope(Dispatchers.Main).launch {
        permissionUtils.checkPermission(this@SplashActivity) {
            MainActivity.intent(this@SplashActivity)
        }
    }

}