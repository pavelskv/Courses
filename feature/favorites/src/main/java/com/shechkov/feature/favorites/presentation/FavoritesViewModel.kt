package com.shechkov.feature.favorites.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shechkov.core.presentation.adapter.EmptyUi
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.presentation.courses.ObserveUpdateFavorites
import com.shechkov.core.presentation.courses.UpdateFavoritesCommunication
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val coursesInteractor: CoursesInteractor,
    private val coursesDomainToUiMapper: CoursesDomain.Mapper<List<ItemUi>>,
    private val favoritesCommunication: FavoritesCommunication,
    private val updateFavoritesCommunication: UpdateFavoritesCommunication,
) : ViewModel(), ObserveFavorites, ChangeFavorite, ObserveUpdateFavorites {

    fun fetchCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            val courses = coursesInteractor.favorites()
            withContext(Dispatchers.Main) {
                val coursesUi = courses.map(coursesDomainToUiMapper).ifEmpty { listOf(EmptyUi()) }
                favoritesCommunication.setValue(coursesUi)
            }
        }
    }

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<List<ItemUi>>,
    ) = favoritesCommunication.observe(owner, observer)

    override fun changeFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            coursesInteractor.changeFavorite(id)
            withContext(Dispatchers.Main) {
                updateFavoritesCommunication.setValue(Unit)
            }
        }
    }

    override fun observeUpdateFavorites(
        owner: LifecycleOwner,
        observer: Observer<Unit>,
    ) = updateFavoritesCommunication.observe(owner, observer)

}