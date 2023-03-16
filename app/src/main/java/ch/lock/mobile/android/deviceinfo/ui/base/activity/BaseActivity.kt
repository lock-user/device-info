package ch.lock.mobile.android.deviceinfo.ui.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity: AppCompatActivity() {

    private var compositeDisposable = CompositeDisposable()

    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.clear()
    }

}