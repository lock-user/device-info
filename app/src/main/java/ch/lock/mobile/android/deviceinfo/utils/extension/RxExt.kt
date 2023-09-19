package ch.lock.mobile.android.deviceinfo.utils.extension

import android.util.Log
import hu.akarnokd.rxjava3.bridge.RxJavaBridge
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import io.reactivex.Completable as CompletableV2
import io.reactivex.Flowable as FlowableV2
import io.reactivex.Maybe as MaybeV2
import io.reactivex.Observable as ObservableV2
import io.reactivex.Single as SingleV2

private const val TAG = "RxExt"

object MySchedulers {
    /**
     * @return 현재 스케줄러
     */
    fun current(): Scheduler = Schedulers.from { it.run() }
}

/**
 * Timer
 */
fun timer(delay: Long, onDelayed: () -> Unit): Disposable =
    Completable.timer(delay, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onDelayed) {
            Log.e(TAG, it.toString())
        }

/**
 * execute main thread
 */
fun runOnMainThread(runnable: () -> Unit): Disposable = Observable.empty<Unit>()
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribeBy(
        onComplete = runnable,
        onError = {
            Log.e(TAG, it.toString())
        }
    )

/**
 * execute background thread
 */
fun runOnBackgroundThread(runnable: () -> Unit): Disposable = Observable.empty<Unit>()
    .subscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
    .subscribeBy(
        onComplete = runnable,
        onError = {
            Log.e(TAG, it.toString())
        }
    )

/**
 * @return empty Disposable
 */
fun emptyDisposable(): Disposable = Disposable.empty()

/**
 * @return Observable v2 to v3
 */
fun <T : Any> ObservableV2<T>.toV3(): Observable<T> = RxJavaBridge.toV3Observable(this)

/**
 * @return Flowable v2 to v3
 */
fun <T : Any> FlowableV2<T>.toV3(): Flowable<T> = RxJavaBridge.toV3Flowable(this)

/**
 * @return Single v2 to v3
 */
fun <T : Any> SingleV2<T>.toV3(): Single<T> = RxJavaBridge.toV3Single(this)

/**
 * @return Maybe v2 to v3
 */
fun <T> MaybeV2<T>.toV3(): Maybe<T> = RxJavaBridge.toV3Maybe(this)

/**
 * @return Completable v2 to v3
 */
fun <T> CompletableV2.toV3(): Completable = RxJavaBridge.toV3Completable(this)