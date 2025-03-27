package com.shechkov.feature.favorites.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.courses.courseAdapterDelegate
import com.shechkov.feature.favorites.databinding.FragmentFavoritesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FavoritesViewModel, FragmentFavoritesBinding>(
    FragmentFavoritesBinding::inflate
) {
    override val viewModel: FavoritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coursesAdapter = ListDelegationAdapter<List<ItemUi>>(
            courseAdapterDelegate(viewModel)
        )

        binding.coursesListView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coursesAdapter
        }

        viewModel.observe(viewLifecycleOwner) {
            coursesAdapter.items = it
            coursesAdapter.notifyDataSetChanged()
        }

        viewModel.fetchCourses()
    }
}