package com.jainamj.myapplication.ui.dashboard.presenter

import com.jainamj.myapplication.base.mvp.BasePresenter
import com.jainamj.myapplication.base.mvp.BaseView

interface DashboardContract{
    interface View:BaseView
    interface Presenter:BasePresenter<View>
}