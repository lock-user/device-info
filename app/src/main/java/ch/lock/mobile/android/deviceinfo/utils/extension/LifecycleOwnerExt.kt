package ch.lock.mobile.android.deviceinfo.utils.extension

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import ch.lock.mobile.android.deviceinfo.ui.base.dialog.BaseDialogFragment
import ch.lock.mobile.android.deviceinfo.ui.base.viewmodel.BaseViewModel
import ch.lock.mobile.android.deviceinfo.ui.dialog.progress.ProgressDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private const val TAG: String = "LifecycleOwnerExt"

/**
 * @return context
 */
val LifecycleOwner.lifecycleContext: Context
    get() = when (this) {
        is Activity -> this
        is Fragment -> this.context
            ?: throw NullPointerException("The context of the fragment is null.")
        else -> throw NullPointerException("This method can only use Activity or Fragment.")
    }

/**
 * @return FragmentManager
 */
val LifecycleOwner.lifecycleFragmentManager: FragmentManager
    get() = when (this) {
        is AppCompatActivity -> this.supportFragmentManager
        is Fragment -> this.childFragmentManager
        else -> throw NullPointerException("This method can only use Activity or Fragment.")
    }

/**
 * collect 동작 최적화
 */
fun LifecycleOwner.repeatOnStarted(block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED, block)
    }
}

/**
 * subscribe of BaseViewModel default event
 */
fun LifecycleOwner.observeBaseViewModelEvent(
    viewModel: BaseViewModel,
    isShowToast: Boolean = true,
    isShowProgress: Boolean = true,
    isDismissProgress: Boolean = true
) = repeatOnStarted {
    viewModel.baseEventFlow.collect { event ->
        when (event) {
            is BaseViewModel.Event.ShowToast -> {
                if (isShowToast) Toast.makeText(
                    lifecycleContext,
                    event.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
            is BaseViewModel.Event.ShowProgress -> {
                if (isShowProgress) showProgressDialog()
            }
            is BaseViewModel.Event.DismissProgress -> {
                if (isDismissProgress) dismissProgressDialog()
            }
        }
    }
}

/**
 * show ProgressDialog
 */
fun LifecycleOwner.showProgressDialog() = ProgressDialog.newInstance()
    .show(lifecycleFragmentManager, ProgressDialog.TAG)

/**
 * dismiss ProgressDialog
 */
fun LifecycleOwner.dismissProgressDialog() {
    val dialog: Fragment? = lifecycleFragmentManager.findFragmentByTag(ProgressDialog.TAG)

    if (dialog != null) {
        dismissDialog(ProgressDialog.TAG)
    } else {
        timer(500) {
            dismissDialog(ProgressDialog.TAG)
        }
    }
}

/**
 * dismiss DialogFragment
 */
fun LifecycleOwner.dismissDialog(dialogTag: String) {
    lifecycleFragmentManager.findFragmentByTag(dialogTag).let { dialog ->
        when (dialog) {
            is BaseDialogFragment -> dialog.dismiss()
        }
    }
}