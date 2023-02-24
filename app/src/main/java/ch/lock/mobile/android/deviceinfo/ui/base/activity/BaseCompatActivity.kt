package ch.lock.mobile.android.deviceinfo.ui.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

abstract class BaseCompatActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: T

    abstract val isScreenCaptureBlock: Boolean

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        // activity 내 화면 캡쳐 차단 여부
        if (isScreenCaptureBlock) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }
    }

}