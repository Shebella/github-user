package com.moneyforward.github.user.data.repository

import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.ui.dto.UserDetail
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserList(query: String): Flow<List<User>>

    fun getUserDetail(username: String): Flow<UserDetail>
}
