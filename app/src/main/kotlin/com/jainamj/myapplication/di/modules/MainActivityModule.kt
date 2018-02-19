package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.di.scopes.ActivityScope
import com.jainamj.myapplication.ui.main.presenter.MainPresenter
import com.jainamj.myapplication.ui.main.presenter.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [CompositeDisposableModule::class])
class MainActivityModule {
    @Provides
    @ActivityScope
    fun mainActivityPresenter(mainPresenter: MainPresenterImpl): MainPresenter = mainPresenter
}