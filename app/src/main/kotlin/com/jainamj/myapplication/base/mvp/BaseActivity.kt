package com.jainamj.myapplication.base.mvp

import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.jainamj.myapplication.App
import com.jainamj.myapplication.base.network.ConnectivityUtils
import com.jainamj.myapplication.di.components.AppComponent
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : MvpActivity<V, P>(), BaseView {

    private var progressDialog: Dialog? = null

    override fun showLoading(message: String) {
        DialogUtils.showLoading(this, message)
    }

    override fun hideLoading() {
        progressDialog?.let {
            if (it.isShowing) it.cancel()
            progressDialog = null
        }
    }

    override fun clientError(errorMessage: String) = toast("Something went wrong!")

    override fun networkError(errorMessage: String) {
        if (!isNetworkConnected())
            toast("Please check your internet connection and retry !")
    }

    private fun isNetworkConnected(): Boolean {
        return ConnectivityUtils.isConnectedToInternet(this)
    }

    override fun onTimeout() = longToast("Server is taking too long to respond.\nPlease try again")

    override fun serverError(errorMessage: String) =
            longToast("Something went wrong on the server side !")

    override fun unauthenticated() {
        longToast("Your session has expired. Please login again.")
        finish()
        // TODO: go back to login screen
    }

    override fun unexpectedError(errorMessage: String) = toast(errorMessage)

    override fun unexpectedError(exception: RuntimeException) {
        exception.message?.let { toast(it) }
    }

    var appComponent: AppComponent? = null
        private set
        get() = App.appComponent

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun injectDependencies()

}