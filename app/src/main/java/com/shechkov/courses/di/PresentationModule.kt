package com.shechkov.courses.di

import android.content.Context
import android.content.SharedPreferences
import com.shechkov.core.presentation.OpenBrowser
import com.shechkov.core.presentation.courses.UpdateFavoritesCommunication
import com.shechkov.courses.presentation.InitialScreen
import com.shechkov.courses.core.domain.account.UserAuthorization
import com.shechkov.courses.domain.BaseUserAuthorization
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    @Singleton
    fun provideOpenBrowser(@ApplicationContext context: Context): OpenBrowser =
        OpenBrowser.Base(context)

    @Provides
    @Singleton
    fun provideUserAuthorization(sharedPreferences: SharedPreferences): UserAuthorization =
        BaseUserAuthorization(sharedPreferences)

    @Provides
    @Singleton
    fun provideInitialScreen(userAuthorization: UserAuthorization): InitialScreen =
        InitialScreen.Base(userAuthorization)

    @Provides
    @Singleton
    fun provideUpdateFavoritesCommunication(): UpdateFavoritesCommunication =
        UpdateFavoritesCommunication.Base()

}