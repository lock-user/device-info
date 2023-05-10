package ch.lock.mobile.android.deviceinfo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import ch.lock.mobile.android.deviceinfo.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

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