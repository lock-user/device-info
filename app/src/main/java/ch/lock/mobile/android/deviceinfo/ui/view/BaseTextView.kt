package ch.lock.mobile.android.deviceinfo.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

@SuppressLint("PrivateResource", "CustomViewStyleable")
open class BaseTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        val typedArray: TypedArray = context.obtainStyledAttributes(
            attrs,
            androidx.constraintlayout.widget.R.styleable.AppCompatTextView,
            defStyleAttr,
            0
        )

        includeFontPadding = false
        typedArray.recycle()
    }

}