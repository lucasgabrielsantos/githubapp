package com.lucas.github.domain.model

data class OwnerEntity(
    val reposUrl: String = "",
    val followingUrl: String = "",
    val starredUrl: String = "",
    val followersUrl: String = "",
    val url: String = "",
    val login : String = "",
    val subscriptionsUrl: String = "",
    val avatarUrl: String?,
    val id: Int = 0,
)