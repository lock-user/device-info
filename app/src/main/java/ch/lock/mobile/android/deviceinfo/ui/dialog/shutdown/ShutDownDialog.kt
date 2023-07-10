package ch.lock.mobile.android.deviceinfo.ui.dialog.shutdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.databinding.DialogShutdownBinding
import ch.lock.mobile.android.deviceinfo.ui.base.dialog.BaseDialogFragment
import ch.lock.mobile.android.deviceinfo.utils.ProcessManager
import org.koin.android.ext.android.inject

class ShutDownDialog : BaseDialogFragment() {

    companion object {
        const val TAG: String = "ShutDownDialog"

        /**
         * ShutDownDialog fragment bundle 설정
         */
        fun newInstance(): ShutDownDialog = ShutDownDialog().apply {
            arguments = Bundle()
        }
    }

    private val binding: DialogShutdownBinding by lazy {
        DialogShutdownBinding.bind(requireView())
    }

    private val processManager: ProcessManager by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.dialog_shutdown,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.activity = this
    }

    fun shutdown() {
        processManager.exit()
    }

}