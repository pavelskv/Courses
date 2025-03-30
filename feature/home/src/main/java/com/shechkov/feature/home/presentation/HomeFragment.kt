package com.shechkov.feature.home.presentation

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.adapter.progressAdapterDelegate
import com.shechkov.core.presentation.courses.CourseDiffCallback
import com.shechkov.core.presentation.courses.courseAdapterDelegate
import com.shechkov.core.ui.R
import com.shechkov.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coursesAdapter = AsyncListDifferDelegationAdapter<ItemUi>(
            CourseDiffCallback(),
            progressAdapterDelegate(),
            courseAdapterDelegate(viewModel)
        )

        binding.coursesListView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = coursesAdapter
        }

        coursesAdapter.registerAdapterDataObserver(object: RecyclerView.AdapterDataObserver(){
            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                binding.coursesListView.smoothScrollToPosition(0)
            }
        })

        binding.sortingButton.setOnClickListener {
            viewModel.sortCoursesByPublishDate()
        }

        viewModel.observe(viewLifecycleOwner) {
            coursesAdapter.items = it
        }

        viewModel.observeUpdateFavorites(viewLifecycleOwner) {
            viewModel.fetchCourses()
        }

        viewModel.init()
    }
}