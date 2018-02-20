package com.jainamj.myapplication.ui.main.view

import com.jainamj.myapplication.base.mvp.BaseView

interface MainView : BaseView {
    fun showUserData(message: String)
    fun setGitEditText(userName: String?)
    fun showEmptyUserNameError()
}