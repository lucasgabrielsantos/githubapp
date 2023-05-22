package com.lucas.github.domain.usecase

import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow


class GetListGitHubUseCase(private val repository: GitHubRepository) {

    fun getListGitHubRepositories(): Flow<GitHub> = repository.getListGitHubRepositories()

}
