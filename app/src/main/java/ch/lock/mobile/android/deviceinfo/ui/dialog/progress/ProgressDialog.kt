package ch.lock.mobile.android.deviceinfo.ui.dialog.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.databinding.DialogProgressBinding
import ch.lock.mobile.android.deviceinfo.ui.base.dialog.BaseDialogFragment

class ProgressDialog: BaseDialogFragment() {

    companion object {
        /**
         * TAG
         */
        const val TAG: String = "ProgressDialog"

        /**
         * ProgressDialog fragment bundle 설정
         */
        fun newInstance(): ProgressDialog = ProgressDialog().apply {
            arguments = Bundle()
        }
    }

    private val binding: DialogProgressBinding by lazy {
        DialogProgressBinding.bind(requireView())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.dialog_progress, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
    }

}