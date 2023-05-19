package com.lucas.github.domain.model

data class GitHub(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val itemsEntity: MutableList<ItemsEntity>
)