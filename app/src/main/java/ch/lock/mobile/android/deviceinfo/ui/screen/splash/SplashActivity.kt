package ch.lock.mobile.android.deviceinfo.ui.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.activity.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivitySplashBinding
import ch.lock.mobile.android.deviceinfo.ui.screen.main.MainActivity
import ch.lock.mobile.android.deviceinfo.ui.screen.setting.SettingViewModel
import ch.lock.mobile.android.deviceinfo.utils.PermissionUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseCompatActivity() {

    companion object {
        const val TAG: String = "SplashActivity"
    }

    private val binding: ActivitySplashBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    private val permissionUtils: PermissionUtils by inject()

    private val settingViewModel: SettingViewModel by viewModel()

    override val isScreenCaptureBlock: Boolean
        get() = initScreenCaptureBlock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPermission()
        initBinding()
    }

    /**
     * 뒤로가기 버튼 비활성화
     */
    override fun onBackPressed() {
        //super.onBackPressed()
    }

    private fun initScreenCaptureBlock(): Boolean = settingViewModel.isCaptureBlock.value == true

    private fun initBinding() {
        binding.lifecycleOwner = this
    }

    /**
     * 권한 초기화
     */
    private fun initPermission() = CoroutineScope(Dispatchers.Main).launch {
        permissionUtils.checkPermission(this@SplashActivity) {
            MainActivity.intent(this@SplashActivity)
        }
    }

}