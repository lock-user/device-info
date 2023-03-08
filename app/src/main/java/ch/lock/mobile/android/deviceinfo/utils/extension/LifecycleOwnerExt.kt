package ch.lock.mobile.android.deviceinfo.utils.extension

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

private const val TAG: String = "LifecycleOwnerExt"

val LifecycleOwner.lifeCycleContext: Context
    get() = when (this) {
        is Activity -> this
        is Fragment -> this.context
            ?: throw NullPointerException("The context of the fragment is null.")
        else -> throw NullPointerException("This method can only use Activity or Fragment.")
    }