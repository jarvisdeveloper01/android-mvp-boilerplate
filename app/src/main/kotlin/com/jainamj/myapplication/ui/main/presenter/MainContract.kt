package com.jainamj.myapplication.ui.main.presenter

import com.jainamj.myapplication.base.mvp.BasePresenter
import com.jainamj.myapplication.base.mvp.BaseView

interface MainContract {
    interface View : BaseView {
    }

    interface Presenter : BasePresenter<View> {

    }

}