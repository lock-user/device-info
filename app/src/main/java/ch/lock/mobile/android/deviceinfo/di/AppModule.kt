package ch.lock.mobile.android.deviceinfo.di

import android.content.Context
import ch.lock.mobile.android.deviceinfo.App
import ch.lock.mobile.android.deviceinfo.BuildConfig
import ch.lock.mobile.android.deviceinfo.R
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModule {

    object Named {
        /**
         * app icon
         */
        const val APP_ICON: String = "app_icon"

        /**
         * package name
         */
        const val PACKAGE_NAME: String = "package_name"

        /**
         * version name
         */
        const val VERSION_NAME: String = "version_name"

        /**
         * version code
         */
        const val VERSION_CODE: String = "version_code"
    }

    private val INSTANCE: Module = module {
        single {
            get<Context>() as App
        }
        single(named(Named.APP_ICON)) {
            R.mipmap.ic_launcher
        }
        single(named(Named.PACKAGE_NAME)) {
            get<Context>().packageName
        }
        single(named(Named.VERSION_NAME)) {
            BuildConfig.VERSION_NAME
        }
        single(named(Named.VERSION_CODE)) {
            BuildConfig.VERSION_CODE
        }
    }

    fun getModules(): List<Module> = mutableListOf(
        INSTANCE,
        DataStoreModule.INSTANCE,
        FragmentModule.INSTANCE,
        UtilsModule.INSTANCE,
        ViewModelModule.INSTANCE
    )

}