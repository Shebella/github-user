package com.moneyforward.github.user.data.service

import com.moneyforward.github.user.data.model.SearchUser
import com.moneyforward.github.user.data.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val githubApi: GithubService
) : UserRemoteDataSource {

    override fun fetchUserList(query: String): Flow<Response<SearchUser>> {
        return flow {
            emit(githubApi.searchUsers(query))
        }
    }

    override fun fetchUserDetail(login: String): Flow<Response<User>> {
        return flow {
            emit(githubApi.usersLogin(login))
        }
    }
}
