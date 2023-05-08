package ch.lock.mobile.android.deviceinfo.ui.screen.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.activity.BaseActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivitySettingBinding
import ch.lock.mobile.android.deviceinfo.ui.view.HeaderCallback
import ch.lock.mobile.android.deviceinfo.utils.extension.observeBaseViewModelEvent
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingActivity : BaseActivity(), HeaderCallback {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "SettingActivity"

        /**
         * create SettingActivity intent
         */
        fun createIntent(context: Context): Intent =
            Intent(context, SettingActivity::class.java).apply {}

        /**
         * move to SettingActivity
         */
        fun intent(context: Context) = createIntent(context).also { intent ->
            context.startActivity(intent)
        }
    }

    private val binding: ActivitySettingBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_setting)
    }

    private val viewModel: SettingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initViewModel()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.activity = this
        binding.viewModel = viewModel

        binding.let { binding ->
            binding.settingHeader.headerCallback = this
        }
    }

    private fun initViewModel() {
        observeBaseViewModelEvent(viewModel)
    }

    /**
     * 오픈소스 라이선스 액티비티로 이동
     */
    fun openSourceLicense() {
        startActivity(Intent(this, OssLicensesMenuActivity::class.java))
    }

    /**
     * 뒤로 가기 버튼 클릭 시 설정 화면 종료
     */
    override fun onBackEvent() {
        finish()
    }

    override fun onNextEvent() {
        // empty method
    }

}