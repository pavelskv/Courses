package com.shechkov.courses.presentation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.shechkov.courses.feature.main.presentation.MainFragment
import com.shechkov.feature.account.presentation.AccountFragment
import com.shechkov.feature.favorites.presentation.FavoritesFragment
import com.shechkov.feature.home.presentation.HomeFragment
import com.shechkov.feature.login.LoginFragment
import com.shechkov.feature.onboarding.OnboardingFragment

object Screens {

    fun Main() = FragmentScreen {
        MainFragment()
    }

    fun Onboarding() = FragmentScreen {
        OnboardingFragment()
    }

    fun Login() = FragmentScreen {
        LoginFragment()
    }

    fun Home() = FragmentScreen {
        HomeFragment()
    }

    fun Favorites() = FragmentScreen {
        FavoritesFragment()
    }

    fun Account() = FragmentScreen {
        AccountFragment()
    }


}