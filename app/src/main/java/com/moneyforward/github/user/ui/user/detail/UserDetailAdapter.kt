package com.moneyforward.github.user.ui.user.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.moneyforward.github.user.R
import com.moneyforward.github.user.databinding.ItemRepoBinding
import com.moneyforward.github.user.databinding.ItemUserBinding
import com.moneyforward.github.user.ui.dto.RepoDetail
import com.moneyforward.github.user.ui.dto.UserDetail
import com.moneyforward.github.user.ui.dto.Detail

class UserDetailAdapter : ListAdapter<Detail, ViewHolder>(UserDetailDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.item_user -> {
                val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
                UserViewHolder(binding)
            }
            else -> {
                val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)
                RepoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (val detail = getItem(position)) {
            is UserDetail -> (holder as UserViewHolder).bind(detail)
            is RepoDetail -> (holder as RepoViewHolder).bind(detail)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is UserDetail -> R.layout.item_user
            is RepoDetail -> R.layout.item_repo
        }
    }
}
