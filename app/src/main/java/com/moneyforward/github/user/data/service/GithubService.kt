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

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): Response<User>

    @GET("users/{username}/repos")
    suspend fun getUserRepositories(@Path("username") username: String): Response<List<Repo>>
}
