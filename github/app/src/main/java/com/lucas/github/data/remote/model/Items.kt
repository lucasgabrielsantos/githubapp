package com.lucas.github.data.remote.model

data class Items(
    val stargazersCount: Int = 0,
    val fullName: String = "",
    val description: String = "",
    val owner: Owner,
    val forksCount: Int = 0
)