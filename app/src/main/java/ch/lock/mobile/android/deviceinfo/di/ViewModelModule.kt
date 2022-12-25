package ch.lock.mobile.android.deviceinfo.di

import ch.lock.mobile.android.deviceinfo.ui.main.MainViewModel
import ch.lock.mobile.android.deviceinfo.ui.main.deviceinfo.DeviceInfoViewModel
import ch.lock.mobile.android.deviceinfo.ui.main.usiminfo.UsimInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModule {

    @JvmStatic
    val INSTANCE: Module = module {
        viewModel {
            DeviceInfoViewModel(
                get()
            )
        }
        viewModel {
            MainViewModel()
        }
        viewModel {
            UsimInfoViewModel(
                get()
            )
        }
    }

}