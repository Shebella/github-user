package com.moneyforward.github.user.data.service

import com.moneyforward.github.user.data.model.SearchUser
import com.moneyforward.github.user.data.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserRemoteDataSource {

    fun fetchUserList(query: String): Flow<Response<SearchUser>>

    fun fetchUserDetail(username: String): Flow<Response<User>>
}
