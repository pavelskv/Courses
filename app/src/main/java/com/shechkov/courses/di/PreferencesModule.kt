package com.shechkov.courses.di

import android.content.SharedPreferences
import com.shechkov.courses.core.preferences.PreferencesProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(preferencesProvider: PreferencesProvider): SharedPreferences =
        preferencesProvider.provideSharedPreferences()

}