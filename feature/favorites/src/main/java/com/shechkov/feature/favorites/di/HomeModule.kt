package com.shechkov.feature.favorites.di

import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.courses.core.domain.CourseDomain
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.courses.core.domain.CoursesRepository
import com.shechkov.feature.favorites.presentation.FavoritesCommunication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {

    @Provides
    @ViewModelScoped
    fun provideFavoritesCommunication(): FavoritesCommunication = FavoritesCommunication.Base()

}