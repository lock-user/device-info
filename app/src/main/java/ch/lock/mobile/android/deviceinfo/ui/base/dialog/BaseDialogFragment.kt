package ch.lock.mobile.android.deviceinfo.ui.base.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ch.lock.mobile.android.deviceinfo.utils.extension.lifecycleContext

abstract class BaseDialogFragment : AppCompatDialogFragment() {

    protected val window: Window?
        get() = dialog?.window

    protected var layoutParams: WindowManager.LayoutParams?
        get() {
            return window?.attributes
        }
        set(value) {
            window?.attributes = value
        }

    var onDismissListener: (() -> Unit)? = null

    abstract override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        object : BaseAppcompatDialog(requireContext(), theme) {
            override fun onBackPressed() {
                if (!this@BaseDialogFragment.onBackPressed()) {
                    return
                }
                super.onBackPressed()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutParams = layoutParams?.apply {
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
            flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
            dimAmount = 0.0f
        }
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun show(manager: FragmentManager, tag: String?) = show(
        manager, tag, bundleOf()
    )

    override fun dismiss() {
        if (!isAdded) return

        super.dismiss()
    }

    override fun onDismiss(dialog: DialogInterface) {
        if (!isAdded) return
        onDismissListener?.let {
            it()
        }

        super.onDismiss(dialog)
    }

    fun show(manager: FragmentManager, tag: String?, args: Bundle) {
        val dialog: Fragment? = manager.findFragmentByTag(tag)
        if (dialog != null && dialog.isAdded) {
            return
        }
        arguments = args

        super.show(manager, tag)
    }

    open fun onBackPressed(): Boolean = true

    open fun showToast(message: String?) {
        Toast.makeText(
            lifecycleContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

}