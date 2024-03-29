package ch.lock.mobile.android.deviceinfo.di

import ch.lock.mobile.android.deviceinfo.ui.screen.main.deviceinfo.DeviceInfoFragment
import ch.lock.mobile.android.deviceinfo.ui.screen.main.siminfo.SimInfoFragment
import ch.lock.mobile.android.deviceinfo.ui.screen.main.system.SystemFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.core.module.Module
import org.koin.dsl.module

object FragmentModule {

    val INSTANCE: Module = module {
        fragment {
            DeviceInfoFragment()
        }
        fragment {
            SimInfoFragment()
        }
        fragment {
            SystemFragment()
        }
    }

}