package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.di.scopes.ActivityScope
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenter
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [CompositeDisposableModule::class])
class SplashActivityModule {
    @Provides
    @ActivityScope
    fun splashActivityPresenter(splashPresenter: SplashPresenterImpl): SplashPresenter = splashPresenter
}