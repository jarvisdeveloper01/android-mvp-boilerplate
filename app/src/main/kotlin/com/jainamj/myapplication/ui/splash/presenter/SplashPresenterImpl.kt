package com.jainamj.myapplication.ui.splash.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.ui.splash.view.SplashView
import timber.log.Timber
import javax.inject.Inject

class SplashPresenterImpl @Inject constructor(
        private var mDataManager: DataManager
) : SplashPresenter, MvpBasePresenter<SplashView>() {

    override fun openSpecificActivity() {
        ifViewAttached { it ->
            when {
                mDataManager.isUserLoggedIn() -> it.openDashboardActivity()
                else -> Timber.e("..")
            }
        }
    }

}
