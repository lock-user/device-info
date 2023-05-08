package ch.lock.mobile.android.deviceinfo.ui.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.lock.mobile.android.deviceinfo.utils.base.flow.EventFlow
import ch.lock.mobile.android.deviceinfo.utils.base.flow.MutableEventFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _baseEventFlow = MutableEventFlow<Event>()
    val baseEventFlow: EventFlow<Event> = _baseEventFlow

    /**
     * show toast
     */
    open fun showToast(message: String?) {
        event(Event.ShowToast(message))
    }

    /**
     * show ProgressDialog
     */
    open fun showProgress() {
        event(Event.ShowProgress)
    }

    /**
     * dismiss ProgressDialog
     */
    open fun dismissProgress() {
        event(Event.DismissProgress)
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _baseEventFlow.emit(event)
        }
    }

    /**
     * BaseViewModel default event
     */
    sealed class Event {
        data class ShowToast(val text: String?) : Event()
        object ShowProgress : Event()
        object DismissProgress : Event()
    }

}