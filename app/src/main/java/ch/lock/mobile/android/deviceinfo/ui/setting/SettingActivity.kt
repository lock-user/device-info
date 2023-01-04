package ch.lock.mobile.android.deviceinfo.ui.setting

import android.content.Context
import android.content.Intent
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivitySettingBinding
import ch.lock.mobile.android.deviceinfo.ui.view.HeaderCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingActivity : BaseActivity<ActivitySettingBinding>(), HeaderCallback {

    companion object {
        const val TAG: String = "SettingActivity"

        fun createIntent(context: Context): Intent =
            Intent(context, SettingActivity::class.java).apply {}

        fun intent(context: Context) = createIntent(context).also { intent ->
            context.startActivity(intent)
        }
    }

    private val viewModel: SettingViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_setting

    override fun initView() {
        binding.viewModel = viewModel

        binding.let { binding ->
            binding.settingHeader.headerCallback = this
        }
    }

    /**
     * 뒤로가기 버튼 클릭 시 설정 화면 종료
     */
    override fun onBackEvent() {
        finish()
    }

    override fun onNextEvent() {
        // empty method
    }


}