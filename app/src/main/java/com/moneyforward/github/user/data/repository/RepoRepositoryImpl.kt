package com.moneyforward.github.user.data.repository

import com.moneyforward.github.user.data.service.RepoRemoteDataSource
import com.moneyforward.github.user.domain.util.toRepoDetail
import com.moneyforward.github.user.ui.dto.RepoDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val repoRemoteDataSource: RepoRemoteDataSource
) : RepoRepository {

    override fun getRepositoryList(login: String): Flow<List<RepoDetail>> {
        return repoRemoteDataSource.fetchRepositoryList(login)
            .map { response ->
                response.body()?.let { repoList ->
                    repoList.filter { repo ->
                        repo.fork == false
                    }.map { repo ->
                        repo.toRepoDetail()
                    }
                } ?: emptyList()
            }
    }
}
