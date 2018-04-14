package com.jainamj.myapplication.base.network

import com.google.gson.Gson
import com.jainamj.myapplication.base.mvp.BaseView
import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * disposable observer for activities
 *
 * @param <T> wrapped response object after API call
 */
abstract class MyAppDisposableObserver<T> constructor(private val view: BaseView) : DisposableObserver<T>() {

    override fun onError(throwable: Throwable) {

        view.hideLoading()
        Timber.e("onError: %s", throwable.toString())

        when (throwable) {
            is HttpException -> { // handle HttpException
                val code = throwable.code()
                when (code) {
                    401 -> view.unauthenticated() // log the user out, as his session token is expired..
                    in 400..499 -> { // some thing went wrong on the client side
                        try {
                            // get error string that we receive in postman response
                            val errorString = throwable.response().errorBody()!!.string()
                            // convert errorString into MyAppWrappedError object
                            val wrappedError = Gson().fromJson(errorString, MyAppWrappedError::class.java)
                            // display toast about the error description
                            view.clientError(wrappedError.message)
                        } catch (e: IOException) {
                            e.printStackTrace()
                            view.clientError(throwable.toString())
                        }

                    }
                    in 500..599 -> view.serverError(throwable.toString()) // some thing went wrong on the server side
                    else -> view.unexpectedError(throwable.toString())
                }
            }
            is ConnectException -> view.connectionError(throwable.toString()) // handle ConnectException
            is SocketTimeoutException -> view.onTimeout() // handle SocketTimeoutException
            is IOException -> view.networkError(throwable.toString()) // handle IOException
            else -> view.unexpectedError(throwable.toString())
        }

    }


    override fun onComplete() = Timber.d("onComplete:")

    override fun onNext(@NonNull response: T) {
        Timber.d("onNext:")
        view.hideLoading()
        onSuccess(response)
    }


    protected abstract fun onSuccess(response: T)

}
