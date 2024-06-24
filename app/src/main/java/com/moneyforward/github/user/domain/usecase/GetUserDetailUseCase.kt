package com.moneyforward.github.user.domain.usecase

import com.moneyforward.github.user.data.repository.RepoRepository
import com.moneyforward.github.user.data.repository.UserRepository
import com.moneyforward.github.user.ui.dto.Detail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val repoRepository: RepoRepository
) {
    operator fun invoke(username: String): Flow<List<Detail>> {
        return combine(
            userRepository.getUserDetail(username),
            repoRepository.getRepositoryList(username)
        ) { userDetail, repoDetailList ->
            val detailList = mutableListOf<Detail>()
            detailList.add(userDetail)

            repoDetailList.forEach { repoDetail ->
                detailList.add(repoDetail)
            }

            detailList
        }
    }
}
