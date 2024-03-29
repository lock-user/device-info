package ch.lock.mobile.android.deviceinfo.ui.screen.main.siminfo

import android.os.Bundle
import android.view.View
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.ui.base.fragment.BaseFragment
import ch.lock.mobile.android.deviceinfo.databinding.FragmentSimInfoBinding
import ch.lock.mobile.android.deviceinfo.utils.extension.observeBaseViewModelEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class SimInfoFragment : BaseFragment<FragmentSimInfoBinding>() {

    companion object {
        const val TAG: String = "SimInfoFragment"
    }

    private val viewModel: SimInfoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_sim_info

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