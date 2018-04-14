package com.jainamj.myapplication.base.mvp

import android.app.Dialog
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatDelegate
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.jainamj.myapplication.App
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.network.ConnectivityUtils
import com.jainamj.myapplication.di.components.AppComponent
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import timber.log.Timber


abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : MvpActivity<V, P>(), BaseView {

    private var progressDialog: Dialog? = null

    override fun showLoading(message: String) {
        progressDialog = DialogUtils.showLoading(this, message)
    }

    override fun hideLoading() {
        progressDialog?.let {
            if (it.isShowing) it.cancel()
            progressDialog = null
        }
    }

    override fun clientError(errorMessage: String) = toast(errorMessage)

    override fun networkError(errorMessage: String) {
        Timber.e(errorMessage)
        if (!isNetworkConnected())
            toast(R.string.networkError)
        else
            toast(errorMessage)
    }

    override fun connectionError(errorMessage: String) {
        Timber.e(errorMessage)
        if (!isNetworkConnected())
            toast(R.string.networkError)
        else
            toast(R.string.connectionError)
    }

    private fun isNetworkConnected(): Boolean = ConnectivityUtils.isConnectedToInternet(this)

    override fun onTimeout() = longToast(R.string.timeoutError)

    override fun serverError(errorMessage: String) {
        Timber.e(errorMessage)
        longToast(R.string.serverError)
    }

    override fun unauthenticated() {
        longToast(R.string.unauthenticatedError)
        finishAffinity()
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
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        if (getLayoutRes() != 0)
            setContentView(getLayoutRes())
        initToolbar()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun initToolbar()
    abstract fun injectDependencies()

}

