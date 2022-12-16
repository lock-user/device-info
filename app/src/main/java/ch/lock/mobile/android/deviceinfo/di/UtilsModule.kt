package ch.lock.mobile.android.deviceinfo.di

import ch.lock.mobile.android.deviceinfo.utils.PermissionUtils
import ch.lock.mobile.android.deviceinfo.utils.ResourceProviderImpl
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object UtilsModule {

    val INSTANCE: Module = module {
        single {
            PermissionUtils()
        }
        single {
            ResourceProviderImpl(
                get()
            )
        } bind ResourceProviderImpl::class
    }

}