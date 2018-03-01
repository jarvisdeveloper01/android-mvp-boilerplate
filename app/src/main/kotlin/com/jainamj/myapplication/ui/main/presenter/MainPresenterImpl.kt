package com.jainamj.myapplication.ui.main.presenter

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.jainamj.myapplication.base.network.GitDisposableObserver
import com.jainamj.myapplication.data.DataManager
import com.jainamj.myapplication.data.api.models.git.UserInfo
import com.jainamj.myapplication.data.db.repository.users.User
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

    override fun handleEnterButtonClicked(username: String) {

        Timber.e("username: " + username)

        if (validateUsername(username)) {
            ifViewAttached { view ->
                view.showLoading()
                mCompositeDisposable.add(mDataManager.getUserInfo(username)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : GitDisposableObserver<UserInfo>(view) {
                            override fun onSuccess(response: UserInfo) {
                                mDataManager.setUserId(response.login!!)
                                Timber.e(response.toString())
                                view.showUserData(response.toString())

                                // add user to db
                                val user = User(id = response.id,
                                        name = response.name,
                                        reposUrl = response.reposUrl,
                                        avatarUrl = response.avatarUrl)
                                mDataManager.insertUserToDb(user)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe { Timber.e(it.toString()) }
                            }

                            override fun onError(throwable: Throwable) {
                                super.onError(throwable)
                                view.showUserData(throwable.localizedMessage)
                            }
                        })
                )
            }
        }
    }

    override fun setEditText() = ifViewAttached { it.setGitEditText(mDataManager.getUserId()) }

    private fun validateUsername(username: String): Boolean = when (username.isNotEmpty()) {
        true -> true
        false -> {
            ifViewAttached { it.showEmptyUserNameError() }
            false
        }
    }

    override fun detachView() {
        super.detachView()
        mCompositeDisposable.dispose()
    }
}
