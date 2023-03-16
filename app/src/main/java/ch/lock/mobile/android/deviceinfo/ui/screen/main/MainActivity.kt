package ch.lock.mobile.android.deviceinfo.ui.screen.main

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ch.lock.mobile.android.deviceinfo.App
import ch.lock.mobile.android.deviceinfo.LockNavigationDirections
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.activity.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityMainBinding
import ch.lock.mobile.android.deviceinfo.ui.screen.setting.SettingActivity
import ch.lock.mobile.android.deviceinfo.ui.screen.setting.SettingViewModel
import ch.lock.mobile.android.deviceinfo.utils.ResourceProvider
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseCompatActivity<ActivityMainBinding>() {

    companion object {
        /**
         * TAG
         */
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

    private val resourceProvider: ResourceProvider by inject()

    private val settingViewModel: SettingViewModel by viewModel()

    lateinit var navController: NavController

    override val isScreenCaptureBlock: Boolean
        get() = initScreenCaptureBlock()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
    }

    override fun onBackPressed() {
        // navigation view가 열려있을 때 뒤로가기 버튼을 누르면 navigation view만 닫기
        if (binding.navigationDl.isDrawerOpen(Gravity.LEFT)) {
            binding.navigationDl.closeDrawer(Gravity.LEFT)
        } else {
            exitAppDialog()
        }
    }

    private fun initScreenCaptureBlock(): Boolean = settingViewModel.isCaptureBlock.value == true

    private fun initBinding() {
        binding.activity = this

        navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController

        // tool bar의 sideMenu 버튼과 navigation view 간의 연동
        binding.sideMenu.setOnClickListener {
            // navigationDl의 navigation view 여닫기
            when (binding.navigationDl.isDrawerOpen(Gravity.LEFT)) {
                true -> binding.navigationDl.closeDrawer(Gravity.LEFT)
                else -> binding.navigationDl.openDrawer(Gravity.LEFT)
            }
        }

        binding.navSimInfo.setOnClickListener {
            binding.navigationDl.closeDrawer(Gravity.LEFT)
            replaceToSimInfo()
        }

        binding.navDeviceInfo.setOnClickListener {
            binding.navigationDl.closeDrawer(Gravity.LEFT)
            replaceToDeviceInfo()
        }
    }

    /**
     * 앱 종료 다이얼로그
     */
    private fun exitAppDialog() {
        AlertDialog.Builder(this)
            .setTitle(resourceProvider.getString(R.string.exit_app_dialog_title))
            .setMessage(resourceProvider.getString(R.string.exit_app_dialog_message))
            .setCancelable(false)
            .setPositiveButton(resourceProvider.getString(R.string.check)) { dialog, id ->
                App.exit(this@MainActivity)
            }
            .setNegativeButton(resourceProvider.getString(R.string.cancel)) { dialog, id ->
                dialog.cancel()
            }
            .show()
            .let { Unit }
    }

    /**
     * move to Sim Info Fragment
     */
    private fun replaceToSimInfo() {
        val directions = LockNavigationDirections.actionGlobalSimInfoFragment()
        navController.navigate(directions)
    }

    /**
     * move to Device Info Fragment
     */
    private fun replaceToDeviceInfo() {
        val directions = LockNavigationDirections.actionGlobalDeviceInfoFragment()
        navController.navigate(directions)
    }

    /**
     * move to setting activity
     */
    fun navSetting() {
        binding.navigationDl.closeDrawer(Gravity.LEFT)
        SettingActivity.intent(this)
    }

}