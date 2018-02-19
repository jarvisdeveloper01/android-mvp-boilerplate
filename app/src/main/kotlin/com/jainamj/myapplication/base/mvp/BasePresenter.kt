package com.jainamj.myapplication.base.mvp

import com.hannesdorfmann.mosby3.mvp.MvpPresenter

interface BasePresenter<T : BaseView> : MvpPresenter<T>