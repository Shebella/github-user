package com.moneyforward.github.user.data.repository

import com.moneyforward.github.user.data.service.UserRemoteDataSource
import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.domain.util.toUserDetail
import com.moneyforward.github.user.ui.dto.UserDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override fun getUserList(query: String): Flow<List<User>> {
        return userRemoteDataSource.fetchUserList(query)
            .map { response ->
                response.body()?.items ?: emptyList()
            }
    }

    override fun getUserDetail(login: String): Flow<UserDetail> {
        return userRemoteDataSource.fetchUserDetail(login)
            .map { response ->
                response.body()?.toUserDetail() ?: UserDetail()
            }
    }
}
