package ch.lock.mobile.android.deviceinfo.ui.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ch.lock.mobile.android.deviceinfo.LockNavigationDirections
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.activity.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityMainBinding
import ch.lock.mobile.android.deviceinfo.ui.dialog.shutdown.ShutDownDialog
import ch.lock.mobile.android.deviceinfo.ui.screen.setting.SettingActivity
import ch.lock.mobile.android.deviceinfo.ui.screen.setting.SettingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseCompatActivity() {

    companion object {
        const val TAG: String = "MainActivity"

        /**
         * create MainActivity intent
         */
        fun createIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java).apply {}

        /**
         * move to MainActivity
         */
        fun intent(context: Context) = createIntent(context).also { intent ->
            context.startActivity(intent)
        }
    }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val settingViewModel: SettingViewModel by viewModel()

    private val navController: NavController by lazy {
        (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
    }

    override val isScreenCaptureBlock: Boolean
        get() = initScreenCaptureBlock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
        initView()
    }

    override fun onBackPressed() {
        // navigation view가 열려있을 때 뒤로가기 버튼을 누르면 navigation view만 닫기
        if (binding.navDrawer.isOpen) {
            binding.navDrawer.close()
        } else {
            exitAppDialog()
        }
    }

    private fun initScreenCaptureBlock(): Boolean = settingViewModel.isCaptureBlock.value == true

    private fun initBinding() {
        binding.lifecycleOwner = this
    }

    private fun initView() {
        binding.toolbar.run {
            setNavigationOnClickListener {
                binding.navDrawer.open()
            }
        }
        binding.navView.run {
            setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_sim -> {
                        navSim()
                    }

                    R.id.nav_device -> {
                        navDevice()
                    }

                    R.id.nav_system -> {
                        navSystem()
                    }

                    R.id.nav_settings -> {
                        navSetting()
                    }
                }
                true
            }
        }
    }

    /**
     * 앱 종료 다이얼로그 표시
     */
    private fun exitAppDialog() {
        ShutDownDialog.newInstance().show(supportFragmentManager, ShutDownDialog.TAG)
    }

    /**
     * move to Sim Info Fragment
     */
    private fun navSim() {
        binding.navDrawer.close()
        val directions = LockNavigationDirections.actionGlobalSimInfoFragment()
        navController.navigate(directions)
    }

    /**
     * move to Device Info Fragment
     */
    private fun navDevice() {
        binding.navDrawer.close()
        val directions = LockNavigationDirections.actionGlobalDeviceInfoFragment()
        navController.navigate(directions)
    }

    /**
     * move to System Fragment
     */
    private fun navSystem() {
        binding.navDrawer.close()
        val directions = LockNavigationDirections.actionGlobalSystemFragment()
        navController.navigate(directions)
    }

    /**
     * move to setting activity
     */
    private fun navSetting() {
        binding.navDrawer.close()
        SettingActivity.intent(this)
    }

}