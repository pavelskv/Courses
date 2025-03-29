package com.shechkov.feature.account.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.adapter.ProgressUi
import com.shechkov.core.presentation.adapter.TitleUi
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.presentation.courses.ObserveUpdateFavorites
import com.shechkov.core.presentation.courses.UpdateFavoritesCommunication
import com.shechkov.core.ui.R
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.courses.core.domain.account.UserAuthorization
import com.shechkov.courses.core.navigation.ScreensProvider
import com.shechkov.feature.account.domain.CoursesDomainToMyCoursesMapper
import com.shechkov.feature.account.domain.MyCoursesInteractor
import com.shechkov.feature.account.presentation.adapter.AccountActionsUi
import com.shechkov.feature.account.presentation.adapter.MyCourseUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.collections.plus

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountCommunication: AccountCommunication,
    private val myCoursesInteractor: MyCoursesInteractor,
    private val coursesDomainToMyCoursesMapper: CoursesDomain.Mapper<List<MyCourseUi>>,
    private val userAuthorization: UserAuthorization,
    private val router: Router,
    private val onboardingScreen: ScreensProvider.Onboarding,
    private val updateFavoritesCommunication: UpdateFavoritesCommunication,
) : ViewModel(), AccountActions, ObserveAccount, ChangeFavorite, ObserveUpdateFavorites {

    override fun support() = Unit
    override fun settings() = Unit

    override fun logout() {
        userAuthorization.logout()
        router.newRootScreen(onboardingScreen.provideScreen())
    }

    private val accountList = listOf(AccountActionsUi(), TitleUi(R.string.core_ui_my_courses))

    fun init() {
        accountCommunication.setValue(accountList + ProgressUi())
        fetchAccount()
    }

    fun fetchAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchMyCourses()
        }
    }

    private suspend fun fetchMyCourses() {
        val courses = myCoursesInteractor.courses()
        withContext(Dispatchers.Main) {
            val coursesUi = courses.map(coursesDomainToMyCoursesMapper)
            accountCommunication.setValue(accountList + coursesUi)
        }
    }

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<List<ItemUi>>,
    ) = accountCommunication.observe(owner, observer)

    override fun changeFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            myCoursesInteractor.changeFavorite(id)
            withContext(Dispatchers.Main) {
                updateFavoritesCommunication.setValue(Unit)
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