package com.jainamj.myapplication.ui.main.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.data.DataManager
import timber.log.Timber
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
        private var mDataManager: DataManager
) : MainContract.Presenter, MvpBasePresenter<MainContract.View>() {


}
