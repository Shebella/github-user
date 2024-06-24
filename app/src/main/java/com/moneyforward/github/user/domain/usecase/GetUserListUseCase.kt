package com.moneyforward.github.user.domain.usecase

import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(query: String): Flow<List<User>> {
        return userRepository.getUserList(query)
    }
}
