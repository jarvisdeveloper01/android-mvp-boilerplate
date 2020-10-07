package com.jainamj.myapplication.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseActivity
import com.jainamj.myapplication.ui.main.presenter.MainContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : BaseActivity<MainContract.View,MainContract.Presenter>(),MainContract.View {


    @Inject
    lateinit var mPresenter: MainContract.Presenter

    override fun createPresenter(): MainContract.Presenter = mPresenter
    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun initToolbar() = Unit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
