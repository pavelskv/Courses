package com.shechkov.feature.account.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.shechkov.core.presentation.BaseFragment
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.adapter.progressAdapterDelegate
import com.shechkov.core.presentation.adapter.titleDelegate
import com.shechkov.core.presentation.courses.CourseDiffCallback
import com.shechkov.core.presentation.courses.courseAdapterDelegate
import com.shechkov.feature.account.databinding.FragmentAccountBinding
import com.shechkov.feature.account.presentation.adapter.accountActionsDelegate
import com.shechkov.feature.account.presentation.adapter.myCourseAdapterDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : BaseFragment<AccountViewModel, FragmentAccountBinding>(
    FragmentAccountBinding::inflate
) {
    override val viewModel: AccountViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val accountAdapter = AsyncListDifferDelegationAdapter<ItemUi>(
            CourseDiffCallback(),
            accountActionsDelegate(viewModel),
            titleDelegate(),
            myCourseAdapterDelegate(viewModel),
            progressAdapterDelegate()
        )

        binding.accountListView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = accountAdapter
        }

        viewModel.observe(viewLifecycleOwner) {
            accountAdapter.items = it
        }

        viewModel.observeUpdateFavorites(viewLifecycleOwner){
            viewModel.fetchAccount()
        }

        viewModel.init()
    }
}