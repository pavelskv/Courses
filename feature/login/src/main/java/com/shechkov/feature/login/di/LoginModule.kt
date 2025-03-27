package com.shechkov.feature.login.di

import com.shechkov.feature.login.FieldsValidator
import com.shechkov.feature.login.presentation.LoginCommunication
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class LoginModule {

    @Provides
    @ViewModelScoped
    fun provideLoginCommunication(): LoginCommunication =
        LoginCommunication.Base()

}