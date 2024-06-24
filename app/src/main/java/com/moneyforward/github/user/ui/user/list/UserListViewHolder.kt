package com.moneyforward.github.user.ui.user.list

import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.moneyforward.github.user.R
import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.databinding.ItemUserListBinding
import com.moneyforward.github.user.ui.user.detail.UserDetailFragment

class UserListViewHolder(
    private val binding: ItemUserListBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.user = user
        binding.executePendingBindings()
        binding.root.setOnClickListener {
            val bundle = bundleOf(UserDetailFragment.USERNAME to user.login)
            Navigation.findNavController(binding.root).navigate(
                R.id.action_user_list_to_user_detail,
                bundle
            )
        }
    }
}
