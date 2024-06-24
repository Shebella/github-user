package com.moneyforward.github.user.ui.user.detail

import androidx.recyclerview.widget.RecyclerView
import com.moneyforward.github.user.databinding.ItemUserBinding
import com.moneyforward.github.user.ui.dto.UserDetail

class UserViewHolder(
    val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(userDetail: UserDetail) {
        binding.userDetail = userDetail
        binding.executePendingBindings()
    }
}
