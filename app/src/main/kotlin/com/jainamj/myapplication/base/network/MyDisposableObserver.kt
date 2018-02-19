package com.jainamj.myapplication.base.network

import com.google.gson.Gson
import com.jainamj.myapplication.base.mvp.BaseView
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * disposable observer for activities
 *
 * @param <T> wrapped response object after API call
 */
abstract class MyDisposableObserver<T> constructor(private val view: BaseView) : DisposableObserver<T>() {

    override fun onError(throwable: Throwable) {

        view.hideLoading()
        Timber.e("onError: %s", throwable.toString())

        if (throwable is HttpException) {
            // handle HttpException

            val code = throwable.code()
            if (code == 401) {
                // log the user out, as his session token is expired..
                view.unauthenticated()
            } else if (code in 400..499) {
                // some thing went wrong on the client side
                try {
                    // handle the error response..
                    //      user comes here when login api returns 400 response due to invalid credentials

                    // get error string that we receive in postman response
                    val errorString = throwable.response().errorBody()!!.string()
                    // convert errorString into MyWrappedError object
                    val wrappedError = Gson().fromJson(errorString, MyWrappedError::class.java)
                    // display toast about the error description
                    view.clientError(wrappedError.errorDescription)
                    return
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                view.clientError(throwable.toString())
            } else if (code in 500..599) {
                // some thing went wrong on the server side
                view.serverError(throwable.toString())
            } else {
                view.unexpectedError(throwable.toString())
            }

        } else if (throwable is SocketTimeoutException) {
            // handle SocketTimeoutException
            view.onTimeout()
        } else if (throwable is IOException) {
            // handle IOException
            view.networkError(throwable.toString())
        } else if (throwable is IllegalStateException) {
            // unexpected error
            Timber.e("unexpected error: ")
            view.unexpectedError(throwable.toString())
        } else {
            view.unexpectedError(throwable.toString())
        }

    }


    override fun onComplete() {
        Timber.e("onComplete:")
    }

    override fun onNext(@NonNull response: T) {
        Timber.e("onNext:")
        view.hideLoading()
        onSuccess(response)
    }


    protected abstract fun onSuccess(response: T)

}
