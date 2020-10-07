package com.jainamj.myapplication.ui.splash.presenter

import com.jainamj.myapplication.base.mvp.BasePresenter
import com.jainamj.myapplication.base.mvp.BaseView

interface SplashContract {
    interface View : BaseView{
        fun openDashboardActivity()
        fun openLoginScreen()

    }

    interface Presenter : BasePresenter<View>{
        fun openSpecificActivity()
    }

}