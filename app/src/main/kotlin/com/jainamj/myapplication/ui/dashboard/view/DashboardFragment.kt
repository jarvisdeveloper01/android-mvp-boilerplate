package com.jainamj.myapplication.ui.dashboard.view

import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseFragment
import com.jainamj.myapplication.ui.dashboard.presenter.DashboardContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : BaseFragment<DashboardContract.View, DashboardContract.Presenter>(), DashboardContract.View {


    @Inject
    lateinit var mPresenter: DashboardContract.Presenter
    override fun getLayoutRes(): Int = R.layout.fragment_dashboard
    override fun createPresenter(): DashboardContract.Presenter {
        return mPresenter
    }

}