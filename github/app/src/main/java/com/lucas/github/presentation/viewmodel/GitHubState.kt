package com.lucas.github.presentation.viewmodel

import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.ItemsEntity
import com.lucas.github.domain.model.OwnerEntity

data class GitHubState(
    val isLoading: Boolean = false,
    val showListGitHub: GitHub? = null
) {

    fun showListGitHub(gitHub: GitHub) = GitHubState(
        showListGitHub = gitHub
    )

    fun initialState(initialState: Boolean) = GitHubState(
        isLoading = initialState
    )
}