package com.jainamj.myapplication.di.components

import com.jainamj.myapplication.di.modules.SplashModule
import com.jainamj.myapplication.di.scopes.FragmentScope
import com.jainamj.myapplication.ui.splash.view.SplashFragment
import dagger.Component

@FragmentScope
@Component(modules = [SplashModule::class], dependencies = [AppComponent::class])
interface SplashComponent {
    fun inject(splashActivity: SplashFragment)
}