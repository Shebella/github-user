package com.moneyforward.github.user.domain.util

import com.moneyforward.github.user.data.model.Repo
import com.moneyforward.github.user.data.model.User
import com.moneyforward.github.user.ui.dto.RepoDetail
import com.moneyforward.github.user.ui.dto.UserDetail

fun User.toUserDetail(): UserDetail {
    return UserDetail(
        id = id,
        iconUrl = avatar_url,
        userName = login,
        fullName = name,
        followers = followers,
        following = following
    )
}

fun Repo.toRepoDetail(): RepoDetail {
    return RepoDetail(
        id = id,
        name = name,
        language = language,
        stargazersCount = stargazers_count,
        description = description,
        htmlUrl = html_url
    )
}
