package com.jainamj.myapplication.ui.splash.view

import android.annotation.SuppressLint
import android.os.Bundle
import com.jainamj.myapplication.base.mvp.BaseActivity
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {

    override fun openDashboardActivity() = Unit

    @Inject
    lateinit var mPresenter: SplashPresenter

    override fun createPresenter(): SplashPresenter = mPresenter
    override fun getLayoutRes(): Int = 0
    override fun initToolbar() = Unit


    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.openSpecificActivity()
        // finish() // todo uncomment after testing
    }
}
