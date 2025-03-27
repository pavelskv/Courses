package com.shechkov.feature.account.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.adapter.TitleUi
import com.shechkov.core.presentation.courses.ChangeFavorite
import com.shechkov.core.ui.R
import com.shechkov.courses.core.domain.CoursesDomain
import com.shechkov.courses.core.domain.CoursesInteractor
import com.shechkov.feature.account.domain.CoursesDomainToMyCoursesMapper
import com.shechkov.feature.account.domain.MyCoursesInteractor
import com.shechkov.feature.account.presentation.adapter.AccountActionsUi
import com.shechkov.feature.account.presentation.adapter.MyCourseUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountCommunication: AccountCommunication,
    private val myCoursesInteractor: MyCoursesInteractor,
    private val coursesDomainToMyCoursesMapper: CoursesDomain.Mapper<List<MyCourseUi>>,
) : ViewModel(), AccountActions, ObserveAccount, ChangeFavorite {

    override fun support() = Unit
    override fun settings() = Unit
    override fun logout() = Unit

    fun fetchAccount() {
        viewModelScope.launch(Dispatchers.IO) {
            val courses = myCoursesInteractor.courses()
            withContext(Dispatchers.Main) {
                val accountList = listOf(AccountActionsUi(), TitleUi(R.string.core_ui_my_courses))
                val coursesUi = courses.map(coursesDomainToMyCoursesMapper)

                accountCommunication.setValue(accountList + coursesUi)
            }
        }

    }

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<List<ItemUi>>,
    ) = accountCommunication.observe(owner, observer)

    override fun changeFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            myCoursesInteractor.changeFavorite(id)
        }

    }
}