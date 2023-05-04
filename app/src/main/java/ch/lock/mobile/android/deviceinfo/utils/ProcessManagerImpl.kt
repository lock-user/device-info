package ch.lock.mobile.android.deviceinfo.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.android.ext.android.get
import kotlin.system.exitProcess

class ProcessManagerImpl(
    private val applicationContext: Context
) : ProcessManager {

    /**
     * 종료
     */
    override fun exit() = ExitActivity.intent(applicationContext, false)

}

class ExitActivity : AppCompatActivity() {

    object Extra {
        const val IS_RESTART: String = "ClearTaskActivity.Extra.IS_RESTART"
    }

    companion object {
        fun intent(context: Context, isRestart: Boolean = false) =
            Intent(context, ExitActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                putExtra(Extra.IS_RESTART, isRestart)
            }.let {
                context.startActivity(it)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exit()
    }

    private fun exit() = Completable.fromCallable {
        finishAffinity()
        exitProcess(0)
    }.subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
        .subscribeBy()

}