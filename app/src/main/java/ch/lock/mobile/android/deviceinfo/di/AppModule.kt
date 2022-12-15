package ch.lock.mobile.android.deviceinfo.di

import android.content.Context
import ch.lock.mobile.android.deviceinfo.App
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {

    private val INSTANCE: Module = module {
        single {
            get<Context>() as App
        }
    }

    fun getModules(): List<Module> = mutableListOf(
        INSTANCE,
        UtilsModule.INSTANCE,
        ViewModelModule.INSTANCE
    )

}