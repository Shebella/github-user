package com.moneyforward.github.user.data.service

import com.moneyforward.github.user.data.model.Repo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RepoRemoteDataSource {

    fun fetchRepositoryList(login: String): Flow<Response<List<Repo>>>
}
