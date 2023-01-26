package ch.lock.mobile.android.deviceinfo

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Process
import androidx.core.app.ActivityCompat
import ch.lock.mobile.android.deviceinfo.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import kotlin.system.exitProcess

class App : Application() {

    companion object : KoinComponent {
        /**
         * TAG
         */
        const val TAG: String = "App"

        /**
         * context
         */
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        /**
         * 앱 프로세스 강제 종료
         */
        @JvmStatic
        fun exit(activity: Activity? = null) {
            activity?.let { ActivityCompat.finishAffinity(it) }
            Process.killProcess(Process.myPid())
            exitProcess(0)
        }
    }


    override fun onCreate() {
        super.onCreate()

        initApp()
        initKoin()
    }

    /**
     * 앱 초기화
     */
    private fun initApp() {
        context = this
    }

    /**
     * koin 초기화
     */
    private fun initKoin() = startKoin {
        androidLogger()
        androidContext(this@App)
        fragmentFactory()
        koin.loadModules(AppModule.getModules())
    }

}