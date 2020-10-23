package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.di.scopes.ActivityScope
import com.jainamj.myapplication.di.scopes.FragmentScope
import com.jainamj.myapplication.ui.splash.presenter.SplashContract
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [CompositeDisposableModule::class])
class SplashModule {
    @Provides
    @FragmentScope
    fun splashActivityPresenter(splashPresenter: SplashPresenterImpl): SplashContract.Presenter = splashPresenter
}