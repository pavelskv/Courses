package com.shechkov.feature.home.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.adapter.ProgressUi
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.presentation.courses.ObserveUpdateFavorites
import com.shechkov.core.presentation.courses.UpdateFavoritesCommunication
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.courses.core.domain.CoursesSorting
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coursesInteractor: CoursesInteractor,
    private val coursesDomainToUiMapper: CoursesDomain.Mapper<List<ItemUi>>,
    private val coursesCommunication: CoursesCommunication,
    private val updateFavoritesCommunication: UpdateFavoritesCommunication,
) : ViewModel(), ObserveCourses, ChangeFavorite, ObserveUpdateFavorites {

    fun init(){
        coursesCommunication.setValue(listOf(ProgressUi()))
        fetchCourses()
    }

    fun fetchCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            val courses = coursesInteractor.courses()
            withContext(Dispatchers.Main) {
                val coursesUi = courses.map(coursesDomainToUiMapper)
                coursesCommunication.setValue(coursesUi)
            }
        }
    }

    override fun changeFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            coursesInteractor.changeFavorite(id)
            withContext(Dispatchers.Main) {
                updateFavoritesCommunication.setValue(Unit)
            }
        }
    }

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<List<ItemUi>>,
    ) = coursesCommunication.observe(owner, observer)

    fun sortCoursesByPublishDate() {
        viewModelScope.launch(Dispatchers.IO) {
            val courses = coursesInteractor.courses(sortBy = CoursesSorting.PublishDateDesc())
            withContext(Dispatchers.Main) {
                val coursesUi = courses.map(coursesDomainToUiMapper)
                coursesCommunication.setValue(coursesUi)
            }
        }
    }

    override fun observeUpdateFavorites(
        owner: LifecycleOwner,
        observer: Observer<Unit>,
    ) {
        updateFavoritesCommunication.observe(owner, observer)
    }

}