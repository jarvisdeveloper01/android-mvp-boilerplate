package com.jainamj.myapplication.base.db

import com.jainamj.myapplication.base.mvp.BaseView
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import timber.log.Timber

/**
 * Created by Jarvis SSD 1 on 3/20/2018.
 */
abstract class DbDisposableObserver<T> : DisposableObserver<T>() {

    override fun onError(throwable: Throwable) {
        Timber.e("onError: %s", throwable.toString())
    }


    override fun onComplete() {
        Timber.e("onComplete:")
    }

    override fun onNext(@NonNull response: T) {
        Timber.e("onNext:")
        onSuccess(response)
    }


    protected abstract fun onSuccess(response: T)

}