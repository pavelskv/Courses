package com.shechkov.courses.feature.main.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.courses.core.navigation.LocalCiceroneHolder
import com.shechkov.courses.core.navigation.RouterProvider
import com.shechkov.courses.feature.main.R
import com.shechkov.courses.feature.main.databinding.FragmentTabContainerBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TabContainerFragment : BaseFragment<TabContainerViewModel, FragmentTabContainerBinding>(
    FragmentTabContainerBinding::inflate
), RouterProvider {

    private val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), R.id.ftc_container, childFragmentManager)
    }

    @Inject
    lateinit var ciceroneHolder: LocalCiceroneHolder

    private val containerName: String
        get() = arguments?.getString(EXTRA_NAME) ?: ""

    private val cicerone: Cicerone<Router> by lazy { ciceroneHolder.getCicerone(containerName) }
    override val router: Router by lazy { cicerone.router }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.findFragmentById(R.id.container) == null) {
            viewModel.initScreen(router, containerName)
        }
    }

    override fun onResume() {
        super.onResume()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }

    override val viewModel: TabContainerViewModel by viewModels()

//    override fun onBackPressed(): Boolean {
//        val fragment = childFragmentManager.findFragmentById(R.id.ftc_container)
//        return if (fragment != null && fragment is BackButtonListener
//                && (fragment as BackButtonListener).onBackPressed()) {
//            true
//        } else {
//            (activity as RouterProvider?)!!.router.exit()
//            true
//        }
//    }

    companion object {
        private const val EXTRA_NAME = "tcf_extra_name"

        fun getNewInstance(name: String?) =
            TabContainerFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_NAME, name)
                }
            }
    }
}