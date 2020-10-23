package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.di.scopes.ActivityScope
import com.jainamj.myapplication.di.scopes.FragmentScope
import com.jainamj.myapplication.ui.auth.login.presenter.LoginContract
import com.jainamj.myapplication.ui.auth.login.presenter.LoginPresenterImpl
import com.jainamj.myapplication.ui.splash.presenter.SplashContract
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenterImpl
import dagger.Module
import dagger.Provides

@Module(includes = [CompositeDisposableModule::class])
class LoginModule {
    @Provides
    @FragmentScope
    fun loginPresenter(loginPresenterImpl: LoginPresenterImpl): LoginContract.Presenter = loginPresenterImpl
}