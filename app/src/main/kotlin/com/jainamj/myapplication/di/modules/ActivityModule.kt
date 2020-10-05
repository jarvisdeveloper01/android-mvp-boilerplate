package com.jainamj.myapplication.di.modules

import com.jainamj.myapplication.ui.splash.presenter.SplashPresenter
import com.jainamj.myapplication.ui.splash.presenter.SplashPresenterImpl
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
    fun splashActivityPresenter(splashPresenter: SplashPresenterImpl): SplashPresenter = splashPresenter
}