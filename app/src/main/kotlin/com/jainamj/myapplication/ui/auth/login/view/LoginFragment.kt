package com.jainamj.myapplication.ui.auth.login.view

import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseFragment
import com.jainamj.myapplication.ui.auth.login.presenter.LoginContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginContract.View, LoginContract.Presenter>(), LoginContract.View {
    @Inject
    lateinit var mPresenter: LoginContract.Presenter
    override fun getLayoutRes(): Int = R.layout.fragment_login
    override fun createPresenter(): LoginContract.Presenter {
        return mPresenter
    }
}