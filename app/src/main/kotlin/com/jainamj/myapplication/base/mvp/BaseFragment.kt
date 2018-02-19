package com.jainamj.myapplication.base.mvp

import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.jainamj.myapplication.App
import com.jainamj.myapplication.di.components.AppComponent

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : MvpFragment<V, P>() {
    var appComponent: AppComponent? = null
        private set
        get() = App.appComponent
}