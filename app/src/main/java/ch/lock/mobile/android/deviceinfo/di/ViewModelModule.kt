package ch.lock.mobile.android.deviceinfo.di

import ch.lock.mobile.android.deviceinfo.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModule {

    val INSTANCE: Module = module {
        viewModel {
            MainViewModel(
                get()
            )
        }
    }

}