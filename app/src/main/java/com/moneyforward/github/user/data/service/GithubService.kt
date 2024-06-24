package com.moneyforward.github.user.data.service

import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.data.model.SearchUser
import com.moneyforward.github.user.data.model.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("search/users")
    suspend fun searchUsers(@Query("q") q: String): Response<SearchUser>

    @GET("users/{login}")
    suspend fun usersLogin(@Path("login") login: String): Response<User>

    @GET("users/{login}/repos")
    suspend fun usersRepos(@Path("login") login: String): Response<List<Repo>>
}
