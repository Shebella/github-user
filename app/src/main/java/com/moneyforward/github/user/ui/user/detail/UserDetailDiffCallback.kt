package com.moneyforward.github.user.ui.user.detail

import androidx.recyclerview.widget.DiffUtil
import com.moneyforward.github.user.ui.dto.Detail

class UserDetailDiffCallback : DiffUtil.ItemCallback<Detail>() {

    override fun areItemsTheSame(oldItem: Detail, newItem: Detail): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Detail, newItem: Detail): Boolean {
        return oldItem == newItem
    }
}
