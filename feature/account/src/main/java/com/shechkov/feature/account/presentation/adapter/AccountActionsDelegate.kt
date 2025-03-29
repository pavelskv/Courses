package com.shechkov.feature.account.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.shechkov.core.presentation.adapter.ItemUi
import com.shechkov.core.presentation.courses.CourseUi
import com.shechkov.core.presentation.databinding.ItemCourseBinding
import com.shechkov.core.ui.R
import com.shechkov.feature.account.databinding.ItemAccountActionsBinding
import com.shechkov.feature.account.presentation.AccountActions

fun accountActionsDelegate(
    accountActions: AccountActions,
) =
    adapterDelegateViewBinding<AccountActionsUi, ItemUi, ItemAccountActionsBinding>(
        { layoutInflater, root -> ItemAccountActionsBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            with(binding) {
                supportButton.setOnClickListener {
                    accountActions.support()
                }

                settingsButton.setOnClickListener {
                    accountActions.settings()
                }

                logoutButton.setOnClickListener {
                    accountActions.logout()
                }

            }
        }
    }