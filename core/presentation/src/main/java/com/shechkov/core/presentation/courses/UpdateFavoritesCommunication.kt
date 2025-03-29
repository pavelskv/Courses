package com.shechkov.core.presentation.courses

import com.shechkov.core.presentation.Communication

interface UpdateFavoritesCommunication : Communication.Update<Unit>,
    Communication.Observe<Unit> {
    class Base() : Communication.UiUpdate<Unit>(), UpdateFavoritesCommunication
}