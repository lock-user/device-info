package ch.lock.mobile.android.deviceinfo.ui.main.deviceinfo

import android.os.Bundle
import android.view.View
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseFragment
import ch.lock.mobile.android.deviceinfo.databinding.FragmentDeviceInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeviceInfoFragment : BaseFragment<FragmentDeviceInfoBinding>() {

    companion object {
        const val TAG: String = "DeviceInfoFragment"
    }

    private val viewModel: DeviceInfoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_device_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

}