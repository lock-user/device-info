package ch.lock.mobile.android.deviceinfo.ui.base.dialog

import android.content.Context
import android.view.Window
import androidx.appcompat.app.AppCompatDialog

open class BaseAppcompatDialog @JvmOverloads constructor(
    context: Context,
    theme: Int = 0
): AppCompatDialog(context, theme) {

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

}