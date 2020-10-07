package com.jainamj.myapplication.ui.splash.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.data.DataManager
import timber.log.Timber
import javax.inject.Inject

class SplashPresenterImpl @Inject constructor(
        private var mDataManager: DataManager
) : SplashContract.Presenter, MvpBasePresenter<SplashContract.View>() {

    override fun openSpecificActivity() {
        mDataManager.isUserLoggedIn()
        ifViewAttached { it ->
            when {
                mDataManager.isUserLoggedIn() -> it.openDashboardActivity()
                else -> it.openLoginScreen()
            }
        }
    }

}
