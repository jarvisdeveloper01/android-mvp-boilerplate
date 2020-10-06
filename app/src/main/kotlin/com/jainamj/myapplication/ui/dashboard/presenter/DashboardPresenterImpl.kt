package com.jainamj.myapplication.ui.dashboard.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.ui.main.presenter.MainContract
import javax.inject.Inject

class DashboardPresenterImpl @Inject constructor(
        private var mDataManager: DataManager
) : DashboardContract.Presenter, MvpBasePresenter<DashboardContract.View>()