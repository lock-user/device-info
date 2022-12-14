package ch.lock.mobile.android.deviceinfo.ui.main

import android.os.Bundle
import ch.lock.mobile.android.deviceinfo.R
import ch.lock.mobile.android.deviceinfo.base.BaseCompatActivity
import ch.lock.mobile.android.deviceinfo.databinding.ActivityMainBinding

class MainActivity : BaseCompatActivity<ActivityMainBinding>() {

    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * 뒤로가기 버튼 비활성화
     */
    override fun onBackPressed() {
        //super.onBackPressed()
    }

}