package ch.lock.mobile.android.deviceinfo.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ch.lock.mobile.android.deviceinfo.LockNavigationDirections
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityMainBinding
import ch.lock.mobile.android.deviceinfo.ui.setting.SettingActivity
import ch.lock.mobile.android.deviceinfo.ui.setting.SettingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseCompatActivity<ActivityMainBinding>() {

    companion object {
        const val TAG: String = "MainActivity"

        /**
         * MainActivity intent 생성
         */
        fun createIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java).apply {}

        /**
         * MainActivity로 화면 전환
         */
        fun intent(context: Context) = createIntent(context).also { intent ->
            context.startActivity(intent)
        }
    }

    private val viewModel: MainViewModel by viewModel()
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
            moveTaskToBack(true)
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

        binding.navUsimInfo.setOnClickListener {
            binding.navigationDl.closeDrawer(Gravity.LEFT)
            replaceToSimInfo()
        }

        binding.navDeviceInfo.setOnClickListener {
            binding.navigationDl.closeDrawer(Gravity.LEFT)
            replaceToDeviceInfo()
        }
    }

    /**
     * move to Usim Info Fragment
     */
    private fun replaceToSimInfo() {
        val directions = LockNavigationDirections.actionGlobalUsimInfoFragment()
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