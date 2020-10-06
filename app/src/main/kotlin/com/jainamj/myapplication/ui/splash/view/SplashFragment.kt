package com.jainamj.myapplication.ui.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.jainamj.myapplication.R
import com.jainamj.myapplication.base.mvp.BaseFragment
import com.jainamj.myapplication.ui.splash.presenter.SplashContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
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

}

//class SplashFragment : Fragment() {
//
//
//    override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_splash, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        goToAccountBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.toAccount))
////        goToSettingsBtn.setOnClickListener {
////            it.findNavController().navigate(R.id.toSettings)
////        }
//    }
//
//}