package com.moneyforward.github.user.data.repository

import com.moneyforward.github.user.ui.dto.RepoDetail
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    fun getRepositoryList(login: String): Flow<List<RepoDetail>>
}
