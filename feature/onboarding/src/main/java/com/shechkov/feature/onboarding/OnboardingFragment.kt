package com.shechkov.feature.onboarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.feature.onboarding.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : BaseFragment<OnboardingViewModel, FragmentOnboardingBinding>(
    FragmentOnboardingBinding::inflate
) {
    override val viewModel: OnboardingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coursesAdapter = ListDelegationAdapter(
            onboardingCoursesDelegate()
        )

        binding.continueButton.setOnClickListener {
            viewModel.navigateToLoginScreen()
        }

        binding.onboardingCoursesView.apply {
            layoutManager = StaggeredGridLayoutManager(5, RecyclerView.HORIZONTAL)
            adapter = coursesAdapter
        }

        coursesAdapter.items = listOf(
            OnboardingCourseUi("1C Администрирование"),
            OnboardingCourseUi("Контент маркетинг"),
            OnboardingCourseUi("UX исследователь"),
            OnboardingCourseUi("Геймдизайн"),
            OnboardingCourseUi("Webflow"),

            OnboardingCourseUi("RabbitMQ", selected = true),
            OnboardingCourseUi("B2B маркетинг"),
            OnboardingCourseUi("Веб-аналитика"),
            OnboardingCourseUi("Веб-дизайн"),
            OnboardingCourseUi("Three.js", selected = true),

            OnboardingCourseUi("Трафик"),
            OnboardingCourseUi("Google Аналитика"),
            OnboardingCourseUi("Big Data", selected = true),
            OnboardingCourseUi("Cinema 4D"),
            OnboardingCourseUi("Парсинг"),

            OnboardingCourseUi("Промпт инженеринг"),
            OnboardingCourseUi("Python-разработка"),
        )
        coursesAdapter.notifyDataSetChanged()


    }
}