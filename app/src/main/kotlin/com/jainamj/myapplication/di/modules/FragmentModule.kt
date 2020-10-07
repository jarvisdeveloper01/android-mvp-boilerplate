package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.ui.auth.login.presenter.LoginContract
import com.jainamj.myapplication.ui.auth.login.presenter.LoginPresenterImpl
import com.jainamj.myapplication.ui.dashboard.presenter.DashboardContract
import com.jainamj.myapplication.ui.dashboard.presenter.DashboardPresenterImpl
import com.jainamj.myapplication.ui.splash.presenter.SplashContract
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module
class FragmentModule {
    @Provides
    @FragmentScoped
    fun splashFragment(splashPresenterImpl: SplashPresenterImpl): SplashContract.Presenter = splashPresenterImpl

    @Provides
    @FragmentScoped
    fun loginFragment(loginPresenterImpl: LoginPresenterImpl): LoginContract.Presenter = loginPresenterImpl

    @Provides
    @FragmentScoped
    fun dashboard(dashboardPresenterImpl: DashboardPresenterImpl): DashboardContract.Presenter = dashboardPresenterImpl

}


