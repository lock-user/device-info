package ch.lock.mobile.android.deviceinfo.di

import ch.lock.mobile.android.deviceinfo.utils.PermissionUtils
import org.koin.core.module.Module
import org.koin.dsl.module

object UtilsModule {

    val INSTANCE: Module = module {
        single {
            PermissionUtils()
        }
    }

}