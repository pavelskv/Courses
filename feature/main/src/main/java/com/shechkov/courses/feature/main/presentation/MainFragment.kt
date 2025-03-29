package com.shechkov.courses.feature.main.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.courses.feature.main.R
import com.shechkov.courses.feature.main.databinding.FragmentMainBinding
import com.shechkov.courses.feature.main.presentation.Screens.Tab
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>(
    FragmentMainBinding::inflate
) {
    override val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            binding.navView.selectedItemId = 0
            selectTab(BottomTab.Home())
        }

        binding.navView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> selectTab(BottomTab.Home())
                R.id.navigation_favorites -> selectTab(BottomTab.Favorites())
                R.id.navigation_account -> selectTab(BottomTab.Account())
            }
            true
        }
    }

    private fun selectTab(tab: BottomTab) {
        val fm = childFragmentManager
        var currentFragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                currentFragment = f
                break
            }
        }

        val tabName = tab.toString()

        val newFragment = fm.findFragmentByTag(tabName)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        val transaction = fm.beginTransaction()
        if (newFragment == null) {
            transaction.add(
                R.id.nav_host_fragment_activity_main,
                Tab(tabName).createFragment(fm.fragmentFactory), tabName
            )
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        if (newFragment != null) {
            transaction.show(newFragment)
        }
        transaction.commitNow()
    }
}