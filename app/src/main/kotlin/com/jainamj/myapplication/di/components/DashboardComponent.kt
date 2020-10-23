package com.jainamj.myapplication.di.components

import com.jainamj.myapplication.di.modules.DashboardModule
import com.jainamj.myapplication.di.modules.SplashModule
import com.jainamj.myapplication.di.scopes.FragmentScope
import com.jainamj.myapplication.ui.dashboard.view.DashboardFragment
import dagger.Component

@FragmentScope
@Component(modules = [DashboardModule::class], dependencies = [AppComponent::class])
interface DashboardComponent {
    fun inject(dashboardFragment: DashboardFragment)
}