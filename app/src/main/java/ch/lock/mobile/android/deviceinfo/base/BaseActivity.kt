package ch.lock.mobile.android.deviceinfo.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: T
    private var compositeDisposable = CompositeDisposable()

    abstract fun getLayoutId(): Int
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@BaseActivity, getLayoutId())
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        initView()
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.clear()
    }

}