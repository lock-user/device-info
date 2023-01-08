package ch.lock.mobile.android.deviceinfo.di

import android.content.Context
import ch.lock.mobile.android.deviceinfo.data.local.datastore.setting.SettingPrefRepository
import ch.lock.mobile.android.deviceinfo.data.local.datastore.setting.dataStore
import org.koin.core.module.Module
import org.koin.dsl.module

object DataStoreModule {

    @JvmStatic
    val INSTANCE: Module = module {
        single {
            SettingPrefRepository(
                get<Context>().dataStore
            )
        }
    }

}