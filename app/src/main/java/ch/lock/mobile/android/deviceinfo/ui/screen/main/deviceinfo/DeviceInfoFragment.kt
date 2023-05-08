package ch.lock.mobile.android.deviceinfo.ui.screen.main.deviceinfo

import android.os.Bundle
import android.view.View
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.fragment.BaseFragment
import ch.lock.mobile.android.deviceinfo.databinding.FragmentDeviceInfoBinding
import ch.lock.mobile.android.deviceinfo.utils.extension.observeBaseViewModelEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeviceInfoFragment : BaseFragment<FragmentDeviceInfoBinding>() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "DeviceInfoFragment"
    }

    private val viewModel: DeviceInfoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_device_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        initViewModel()
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

    private fun initViewModel() {
        observeBaseViewModelEvent(viewModel)
    }

}