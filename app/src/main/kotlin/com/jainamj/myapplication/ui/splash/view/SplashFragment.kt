package com.jainamj.myapplication.ui.splash.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseFragment
import com.jainamj.myapplication.di.components.DaggerSplashComponent
import com.jainamj.myapplication.ui.splash.presenter.SplashContract
import javax.inject.Inject

class SplashFragment : BaseFragment<SplashContract.View, SplashContract.Presenter>(), SplashContract.View {


    @Inject
    lateinit var mPresenter: SplashContract.Presenter
    override fun getLayoutRes(): Int = R.layout.fragment_splash

    override fun openDashboardActivity() {
        findNavController().navigate(R.id.action_splashFragment_to_dashboardFragment)
    }

    override fun openLoginScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_loginFragment2)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.openSpecificActivity()
    }

    override fun createPresenter(): SplashContract.Presenter {
        return mPresenter
    }

    override fun injectDependencies() {
        DaggerSplashComponent.builder().appComponent(appComponent).build().inject(this)
    }

}