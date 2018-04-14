package com.jainamj.myapplication.di.components

import com.jainamj.myapplication.di.modules.SplashActivityModule
import com.jainamj.myapplication.di.scopes.ActivityScope
import com.jainamj.myapplication.ui.splash.view.SplashActivity
import dagger.Component

@ActivityScope
@Component(modules = [SplashActivityModule::class], dependencies = [AppComponent::class])
interface SplashComponent {
    fun inject(splashActivity: SplashActivity)
}