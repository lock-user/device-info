package ch.lock.mobile.android.deviceinfo.ui.screen.main

import ch.lock.mobile.android.deviceinfo.ui.base.viewmodel.BaseViewModel
import ch.lock.mobile.android.deviceinfo.utils.ProcessManager
import ch.lock.mobile.android.deviceinfo.utils.extension.timer

class MainViewModel(
    private val processManager: ProcessManager
) : BaseViewModel() {

    /**
     * 앱 종료
     */
    fun exitApp(delay: Long = 0L) = timer(delay) {
        processManager.exit()
    }

}