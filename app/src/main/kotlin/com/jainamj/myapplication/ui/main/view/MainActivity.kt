package com.jainamj.myapplication.ui.main.view

import android.os.Bundle
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseActivity
import com.jainamj.myapplication.di.components.DaggerMainComponent
import com.jainamj.myapplication.ui.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    override fun showUserData(message: String) {
        txtUserData.text = message
    }

    override fun setGitEditText(userName: String?) = etGitUserName.setText(userName)

    override fun showEmptyUserNameError() {
        tilGitUserName.error = getString(R.string.empty_username_error)
    }

    @Inject
    lateinit var mPresenter: MainPresenter

    override fun createPresenter(): MainPresenter = mPresenter
    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun initToolbar() {
        toolbar.setToolbarTitle(R.string.main)
        toolbar.setBackBtnListener { finish() }
    }

    override fun injectDependencies() = DaggerMainComponent.builder()
            .appComponent(appComponent)
            .build()
            .inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.setEditText()
        btnEnter.setOnClickListener { mPresenter.handleEnterButtonClicked(etGitUserName.text.toString().trim()) }
    }

}
