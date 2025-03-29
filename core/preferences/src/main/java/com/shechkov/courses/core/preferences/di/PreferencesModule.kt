package com.shechkov.courses.core.preferences.di

import android.content.Context
import android.content.SharedPreferences
import com.shechkov.courses.core.preferences.PreferencesProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {

    @Provides
    @Singleton
    fun providePreferencesProvider(@ApplicationContext context: Context): PreferencesProvider =
        PreferencesProvider.Base(context)

}