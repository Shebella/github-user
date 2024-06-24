package com.moneyforward.github.user.ui.user.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.databinding.ItemUserListBinding

class UserListAdapter : ListAdapter<User, UserListViewHolder>(UserListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding = ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewHolder(binding)
    }


    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
