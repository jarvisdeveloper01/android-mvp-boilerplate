package com.jainamj.myapplication.ui.main.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.base.network.MyDisposableObserver
import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.ui.main.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
        private var mCompositeDisposable: CompositeDisposable,
        private var mDataManager: DataManager
) : MainPresenter, MvpBasePresenter<MainView>() {

    override fun handleEnterButtonClicked() {

        mCompositeDisposable.add(
                mDataManager.getUserInfo()!!.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : MyDisposableObserver<UserInfo>(view!!) {
                            override fun onSuccess(response: UserInfo) {
                                Timber.e(response.toString())
                                response.name?.let { view.showUserName(it) }
                            }
                        })
        )
    }

    override fun detachView() {
        super.detachView()
        mCompositeDisposable.dispose()
    }
}
