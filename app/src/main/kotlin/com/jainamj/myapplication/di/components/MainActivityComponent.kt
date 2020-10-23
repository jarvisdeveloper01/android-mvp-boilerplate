package com.jainamj.myapplication.di.components

import com.jainamj.myapplication.di.modules.MainActivityModule
import com.jainamj.myapplication.di.modules.SplashModule
import com.jainamj.myapplication.di.scopes.ActivityScope
import com.jainamj.myapplication.ui.main.view.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [AppComponent::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}