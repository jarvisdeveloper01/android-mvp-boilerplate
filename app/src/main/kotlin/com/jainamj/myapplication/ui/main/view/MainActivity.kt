package com.jainamj.myapplication.ui.main.view

import android.os.Bundle
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseActivity
import com.jainamj.myapplication.di.components.DaggerMainActivityComponent
import com.jainamj.myapplication.ui.main.presenter.MainContract
import javax.inject.Inject


class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {


    @Inject
    lateinit var mPresenter: MainContract.Presenter

    override fun createPresenter(): MainContract.Presenter = mPresenter
    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun initToolbar() = Unit


    override fun injectDependencies() =
            DaggerMainActivityComponent.builder().appComponent(appComponent).build().inject(this)
}
