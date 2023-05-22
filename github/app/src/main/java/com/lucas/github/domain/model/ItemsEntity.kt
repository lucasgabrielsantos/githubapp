package com.lucas.github.domain.model

data class ItemsEntity(
    val stargazersCount: Int = 0,
    val fullName: String = "",
    val description: String = "",
    val owner: OwnerEntity,
    val forksCount: Int = 0
)