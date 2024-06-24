package com.moneyforward.github.user.ui.user.list

import androidx.recyclerview.widget.DiffUtil
import com.moneyforward.github.user.data.model.User

class UserListDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
