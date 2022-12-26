package ch.lock.mobile.android.deviceinfo.ui.main

import android.os.Bundle
import android.view.Gravity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ch.lock.mobile.android.deviceinfo.LockNavigationDirections
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityMainBinding
import ch.lock.mobile.android.deviceinfo.utils.ActivityUtils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseCompatActivity<ActivityMainBinding>() {

    companion object {
        const val TAG: String = "MainActivity"
    }

    private val viewModel: MainViewModel by viewModel()

    lateinit var navController: NavController

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
            replaceToUsimInfo()
        }
    }

    private fun replaceToUsimInfo() {
        val directions = LockNavigationDirections.actionGlobalUsimInfoFragment()
        navController.navigate(directions)
    }

    fun navDeviceInfo() {
        binding.navigationDl.closeDrawer(Gravity.LEFT)
        ActivityUtils.getInstance().startDeviceInfoActivity(this)
    }

}