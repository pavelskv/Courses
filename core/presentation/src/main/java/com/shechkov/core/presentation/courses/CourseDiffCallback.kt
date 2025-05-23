package com.shechkov.core.presentation.courses

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.shechkov.core.presentation.adapter.ItemUi

class CourseDiffCallback : ItemCallback<ItemUi>() {

	override fun areItemsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean {
		return oldItem.id() == newItem.id()
	}

	override fun areContentsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean {
		return oldItem.content() == newItem.content()
	}
}