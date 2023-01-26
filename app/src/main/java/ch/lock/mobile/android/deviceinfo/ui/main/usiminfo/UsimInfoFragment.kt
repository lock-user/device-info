package ch.lock.mobile.android.deviceinfo.ui.main.usiminfo

import android.os.Bundle
import android.view.View
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseFragment
import ch.lock.mobile.android.deviceinfo.databinding.FragmentUsimInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsimInfoFragment : BaseFragment<FragmentUsimInfoBinding>() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "UsimInfoFragment"
    }

    private val viewModel: UsimInfoViewModel by viewModel()

    override fun getLayoutId(): Int = R.layout.fragment_usim_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding.viewModel = viewModel
    }

}