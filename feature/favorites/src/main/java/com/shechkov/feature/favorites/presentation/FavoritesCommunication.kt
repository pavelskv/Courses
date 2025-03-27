package com.shechkov.feature.favorites.presentation

import com.shechkov.core.presentation.Communication
import com.shechkov.core.presentation.adapter.ItemUi

interface FavoritesCommunication : Communication.Update<List<ItemUi>>,
    Communication.Observe<List<ItemUi>> {
    class Base() : Communication.UiUpdate<List<ItemUi>>(), FavoritesCommunication
}