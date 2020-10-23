package com.jainamj.myapplication.base.mvp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.jainamj.myapplication.di.components.AppComponent
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.jainamj.myapplication.App

import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.network.ConnectivityUtils
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

import timber.log.Timber

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : MvpFragment<V, P>(), BaseView {

    private var progressDialog: Dialog? = null

    override fun showLoading(message: String) {
        context?.let {
            progressDialog = DialogUtils.showLoading(it, message)
        }
    }

    override fun hideLoading() {
        progressDialog?.let {
            if (it.isShowing) it.cancel()
            progressDialog = null
        }
    }

    override fun clientError(errorMessage: String) {
        context?.let { with(it) { toast(errorMessage) } }
    }

    override fun networkError(errorMessage: String) {
        Timber.e(errorMessage)
        context?.let {
            with(it) {
                if (!isNetworkConnected())
                    toast(R.string.networkError)
                else
                    toast(errorMessage)
            }
        }

    }

    override fun connectionError(errorMessage: String) {
        Timber.e(errorMessage)
        context?.let {
            with(it) {
                with(it) {
                    if (!isNetworkConnected())
                        toast(R.string.networkError)
                    else
                        toast(R.string.connectionError)
                }
            }
        }
    }

    private fun isNetworkConnected(): Boolean = ConnectivityUtils.isConnectedToInternet(context!!)

    override fun onTimeout() {
        context?.let { with(it) { longToast(R.string.timeoutError) } }
    }

    override fun serverError(errorMessage: String) {
        Timber.e(errorMessage)
        context?.let { with(it) { longToast(R.string.serverError) } }
    }

    override fun unauthenticated() {
        context?.let { with(it) { longToast(R.string.unauthenticatedError) } }
        activity?.finishAffinity()
        // TODO: go back to login screen
    }

    override fun unexpectedError(errorMessage: String) {
        context?.let { with(it) { longToast(errorMessage) } }
    }

    override fun unexpectedError(exception: RuntimeException) {
        exception.message?.let { msg -> context?.let { with(it) { longToast(msg) } } }
    }

    var appComponent: AppComponent? = null
        private set
        get() = App.appComponent

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(getLayoutRes(), container, false)

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun injectDependencies()
}
