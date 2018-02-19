package com.jainamj.myapplication.ui.main.view

import android.os.Bundle
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseActivity
import com.jainamj.myapplication.di.components.DaggerMainComponent
import com.jainamj.myapplication.ui.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    override fun showUserName(message: String) {
        txtName.text = message
    }

    @Inject
    lateinit var mPresenter: MainPresenter

    override fun createPresenter(): MainPresenter = mPresenter
    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun injectDependencies() = DaggerMainComponent.builder()
            .appComponent(appComponent)
            .build()
            .inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.handleEnterButtonClicked()
    }
}
