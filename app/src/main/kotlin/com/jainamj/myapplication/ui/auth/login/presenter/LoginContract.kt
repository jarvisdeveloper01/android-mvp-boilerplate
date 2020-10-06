package com.jainamj.myapplication.ui.auth.login.presenter

import com.jainamj.myapplication.base.mvp.BasePresenter
import com.jainamj.myapplication.base.mvp.BaseView

interface LoginContract{
    interface View:BaseView
    interface Presenter:BasePresenter<View>
}