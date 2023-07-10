package ch.lock.mobile.android.deviceinfo.ui.screen.main.system

import android.os.Bundle
import android.view.View
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.databinding.FragmentSystemBinding
import ch.lock.mobile.android.deviceinfo.ui.base.fragment.BaseFragment
import ch.lock.mobile.android.deviceinfo.utils.extension.observeBaseViewModelEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class SystemFragment : BaseFragment<FragmentSystemBinding>() {

    companion object {
        const val TAG: String = "SystemFragment"
    }

    override fun getLayoutId(): Int = R.layout.fragment_system

    private val viewModel: SystemViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        initViewModel()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun initViewModel() {
        observeBaseViewModelEvent(viewModel)
    }

}