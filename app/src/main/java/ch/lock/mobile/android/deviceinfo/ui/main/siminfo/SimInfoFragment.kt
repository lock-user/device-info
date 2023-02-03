package ch.lock.mobile.android.deviceinfo.ui.main.siminfo

import android.os.Bundle
import android.view.View
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseFragment
import ch.lock.mobile.android.deviceinfo.databinding.FragmentSimInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SimInfoFragment : BaseFragment<FragmentSimInfoBinding>() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "SimInfoFragment"
    }

    private val viewModel: SimInfoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_sim_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

}