package ch.lock.mobile.android.deviceinfo.di

import ch.lock.mobile.android.deviceinfo.ui.screen.main.deviceinfo.DeviceInfoViewModel
import ch.lock.mobile.android.deviceinfo.ui.screen.main.siminfo.SimInfoViewModel
import ch.lock.mobile.android.deviceinfo.ui.screen.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModule {

    @JvmStatic
    val INSTANCE: Module = module {

        // device info
        viewModel {
            DeviceInfoViewModel(
                get()
            )
        }

        // setting
        viewModel {
            SettingViewModel(
                get(),
                get(),
                get()
            )
        }

        // sim info
        viewModel {
            SimInfoViewModel(
                get()
            )
        }
    }

}