package ch.lock.mobile.android.deviceinfo.ui.main

import android.os.Bundle
import android.util.Log
import ch.lock.mobile.android.deviceinfo.App
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityMainBinding
import ch.lock.mobile.android.deviceinfo.utils.DeviceUtils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseCompatActivity<ActivityMainBinding>() {

    companion object {
        const val TAG: String = "MainActivity"
    }

    private val viewModel: MainViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
    }

    /**
     * 뒤로가기 버튼 클릭 시 앱 죽임.
     */
    override fun onBackPressed() {
        App.exit(this@MainActivity)
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

}