package ch.lock.mobile.android.deviceinfo.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.databinding.ViewHeaderBinding

class HeaderView : ConstraintLayout {

    var binding: ViewHeaderBinding? = null
    var headerCallback: HeaderCallback? = null

    constructor(context: Context) : this(context, null)

    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : this(
        context,
        attrs,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView()
        getAttrs(attrs, defStyleAttr)
    }

    private fun initView() {
        val inflater: LayoutInflater = LayoutInflater.from(context)

        DataBindingUtil.inflate<ViewHeaderBinding>(inflater, R.layout.view_header, this, true)
            ?.let {
                binding = it

                it.headerBackImage.setOnClickListener {
                    headerCallback?.onBackEvent()
                }

                it.headerNextTextView.setOnClickListener {
                    headerCallback?.onNextEvent()
                }
            }
    }

    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        if (attrs != null) {
            val typedArray: TypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.HeaderView, defStyleAttr, 0)
            val type = typedArray.getString(R.styleable.HeaderView_header_type)
            val title = typedArray.getString(R.styleable.HeaderView_header_title)
            val next = typedArray.getString(R.styleable.HeaderView_header_next)

            binding?.let { binding ->
                binding.headerTitleTextView.text = title

                when (type) {
                    "0" -> {
                        binding.headerTitleTextView.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.white
                            )
                        binding.headerBackImage.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.white
                            )
                        binding.headerNextTextView.text = next
                        binding.headerNextTextView.setTextColor(
                            ContextCompat.getColor(
                                context,
                                R.color.white
                            )
                        )
                        binding.headerNextTextView.background =
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.header_button_background
                            )
                        binding.headerNextTextView.visibility = View.VISIBLE
                    }
                    "1" -> {
                        binding.headerTitleTextView.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.color_35373d
                            )
                        binding.headerBackImage.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.color_35373d
                            )
                        binding.headerNextTextView.text = next
                        binding.headerNextTextView.setTextColor(
                            ContextCompat.getColor(
                                context,
                                R.color.white
                            )
                        )
                        binding.headerNextTextView.background =
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.header_button_background
                            )
                        binding.headerNextTextView.visibility = View.VISIBLE
                    }
                    "2" -> {
                        binding.headerTitleTextView.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.white
                            )
                        binding.headerBackImage.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.white
                            )
                        binding.headerNextTextView.text = ""
                        binding.headerNextTextView.visibility = View.INVISIBLE
                    }
                    "3" -> {
                        binding.headerTitleTextView.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.color_35373d
                            )
                        binding.headerBackImage.background =
                            ContextCompat.getDrawable(
                                context,
                                R.color.color_35373d
                            )
                        binding.headerNextTextView.text = ""
                        binding.headerNextTextView.visibility = View.INVISIBLE
                    }
                }
            }
            typedArray.recycle()
        }
    }

    /**
     * 버튼 비활성화
     */
    fun disableView() {
        val binding = binding

        if (binding != null) {
            binding.headerNextTextView.isEnabled = false
        }
    }

    /**
     * 버튼 활성화
     */
    fun enableView() {
        val binding = binding

        if (binding != null) {
            binding.headerNextTextView.isEnabled = true
        }
    }

}

interface HeaderCallback {
    fun onBackEvent()
    fun onNextEvent()
}