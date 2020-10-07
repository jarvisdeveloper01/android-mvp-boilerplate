package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.ui.main.presenter.MainContract
import com.jainamj.myapplication.ui.main.presenter.MainPresenterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module()
class ActivityModule {

    @Provides
    @ActivityScoped
    fun mainActivityPresenter(mainPresenterImpl: MainPresenterImpl): MainContract.Presenter = mainPresenterImpl
}