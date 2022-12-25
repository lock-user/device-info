package ch.lock.mobile.android.deviceinfo.ui.main.deviceinfo

import android.os.Bundle
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityDeviceInfoBinding
import org.koin.android.ext.android.inject

class DeviceInfoActivity : BaseCompatActivity<ActivityDeviceInfoBinding>() {

    companion object {
        const val TAG: String = "DeviceInfoActivity"
    }

    private val viewModel: DeviceInfoViewModel by inject()

    override fun getLayoutId(): Int = R.layout.activity_device_info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

}