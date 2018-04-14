package com.jainamj.myapplication.ui.splash.presenter

import com.jainamj.myapplication.base.mvp.BasePresenter
import com.jainamj.myapplication.ui.splash.view.SplashView

interface SplashPresenter : BasePresenter<SplashView> {
    fun openSpecificActivity()
}