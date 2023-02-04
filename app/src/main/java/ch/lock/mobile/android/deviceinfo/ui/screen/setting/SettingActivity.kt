package ch.lock.mobile.android.deviceinfo.ui.screen.setting

import android.content.Context
import android.content.Intent
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.activity.BaseActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivitySettingBinding
import ch.lock.mobile.android.deviceinfo.ui.view.HeaderCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingActivity : BaseActivity<ActivitySettingBinding>(), HeaderCallback {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "SettingActivity"

        /**
         * SettingActivity intent 생성
         */
        fun createIntent(context: Context): Intent =
            Intent(context, SettingActivity::class.java).apply {}

        /**
         * SettingActivity로 화면 전환
         */
        fun intent(context: Context) = createIntent(context).also { intent ->
            context.startActivity(intent)
        }
    }

    private val viewModel: SettingViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_setting

    override fun initView() {
        binding.lifecycleOwner = this
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