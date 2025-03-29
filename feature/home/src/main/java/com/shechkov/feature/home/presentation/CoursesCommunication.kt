package com.shechkov.feature.home.presentation

import com.shechkov.core.presentation.Communication
import com.shechkov.core.presentation.adapter.ItemUi

interface CoursesCommunication : Communication.Update<List<ItemUi>>,
    Communication.Observe<List<ItemUi>> {
    class Base() : Communication.UiUpdate<List<ItemUi>>(), CoursesCommunication
}