package com.jainamj.myapplication.base.mvp

import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseView : MvpView {
    fun clientError(errorMessage: String)
    fun hideLoading()
    fun networkError(errorMessage: String)
    fun onTimeout()
    fun serverError(errorMessage: String)
    fun unauthenticated()
    fun unexpectedError(errorMessage: String)
    fun unexpectedError(exception: RuntimeException)
    fun showLoading(message: String = "")
}