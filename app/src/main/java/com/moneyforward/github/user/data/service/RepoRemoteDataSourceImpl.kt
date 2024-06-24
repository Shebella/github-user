package com.moneyforward.github.user.data.service

import com.moneyforward.github.user.data.model.Repo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RepoRemoteDataSourceImpl @Inject constructor(
    private val githubApi: GithubService
) : RepoRemoteDataSource {

    override fun fetchRepositoryList(username: String): Flow<Response<List<Repo>>> {
        return flow {
            emit(githubApi.getUserRepositories(username))
        }
    }
}
