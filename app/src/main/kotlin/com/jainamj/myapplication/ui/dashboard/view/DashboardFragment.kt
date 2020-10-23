package com.jainamj.myapplication.ui.dashboard.view

import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseFragment
import com.jainamj.myapplication.di.components.DaggerDashboardComponent
import com.jainamj.myapplication.ui.dashboard.presenter.DashboardContract
import javax.inject.Inject

class DashboardFragment : BaseFragment<DashboardContract.View, DashboardContract.Presenter>(), DashboardContract.View {


    @Inject
    lateinit var mPresenter: DashboardContract.Presenter
    override fun getLayoutRes(): Int = R.layout.fragment_dashboard
    override fun createPresenter(): DashboardContract.Presenter {
        return mPresenter
    }

    override fun injectDependencies() =
            DaggerDashboardComponent.builder().appComponent(appComponent).build().inject(this)

}