package com.shechkov.courses.di

import com.github.terrakok.cicerone.Screen
import com.shechkov.core.presentation.NavigationCommunication
import com.shechkov.courses.core.navigation.ScreensProvider
import com.shechkov.courses.feature.main.presentation.BottomTabScreenProvider
import com.shechkov.courses.presentation.Screens
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Provides
    @Singleton
    fun provideNavigationCommunication(): NavigationCommunication =
        NavigationCommunication.Base()

    @Provides
    fun provideLoginScreen(): ScreensProvider.Login = ScreensProvider.Login(Screens.Login())

    @Provides
    fun provideMainScreen(): ScreensProvider.Main = ScreensProvider.Main(Screens.Main())

    @Provides
    fun provideHomeScreen(): ScreensProvider.Home = ScreensProvider.Home(Screens.Home())

    @Provides
    fun provideFavoritesScreen(): ScreensProvider.Favorites =
        ScreensProvider.Favorites(Screens.Favorites())

    @Provides
    fun provideAccountScreen(): ScreensProvider.Account = ScreensProvider.Account(Screens.Account())

    @Provides
    fun provideOnboardingScreen(): ScreensProvider.Onboarding = ScreensProvider.Onboarding(Screens.Onboarding())

    @Provides
    @Singleton
    fun provideBottomTabScreenProvider(
        homeScreen: ScreensProvider.Home,
        favoritesScreen: ScreensProvider.Favorites,
        accountScreen: ScreensProvider.Account,
    ): BottomTabScreenProvider =
        BottomTabScreenProvider.Base(homeScreen, favoritesScreen, accountScreen)


}