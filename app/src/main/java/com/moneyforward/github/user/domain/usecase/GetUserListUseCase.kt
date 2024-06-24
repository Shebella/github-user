package com.moneyforward.github.user.domain.usecase

import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(query: String): Flow<List<User>> {
        return flow {
            emitAll(userRepository.getUserList(query))
        }
    }
}
