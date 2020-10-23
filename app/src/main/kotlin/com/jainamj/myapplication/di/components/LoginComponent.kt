package com.jainamj.myapplication.di.components

import com.jainamj.myapplication.di.modules.LoginModule
import com.jainamj.myapplication.di.modules.SplashModule
import com.jainamj.myapplication.di.scopes.FragmentScope
import com.jainamj.myapplication.ui.auth.login.view.LoginFragment
import dagger.Component

@FragmentScope
@Component(modules = [LoginModule::class], dependencies = [AppComponent::class])
interface LoginComponent {
    fun inject(loginFragment: LoginFragment)
}