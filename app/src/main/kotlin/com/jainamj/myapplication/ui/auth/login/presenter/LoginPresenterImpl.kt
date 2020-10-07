package com.jainamj.myapplication.ui.auth.login.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.ui.dashboard.presenter.DashboardContract
import com.jainamj.myapplication.ui.main.presenter.MainContract
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
        private var mDataManager: DataManager
) : LoginContract.Presenter, MvpBasePresenter<LoginContract.View>()
