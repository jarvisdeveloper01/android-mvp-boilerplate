package com.jainamj.myapplication.ui.main.presenter

import com.jainamj.myapplication.base.mvp.BasePresenter
import com.jainamj.myapplication.ui.main.view.MainView

interface MainPresenter : BasePresenter<MainView> {
    fun handleEnterButtonClicked(username: String)
    fun setEditText()
}