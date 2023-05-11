package com.lucas.github.domain.usecase

import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow

class GetListGitHubUseCase(private val repository: GitHubRepository) {

    fun getListGitHubRepositories(
        query: String,
        page: Int,
        sort: String
    ): Flow<GitHub> {
        return repository.getListGitHubRepositories(query, page, sort)
    }
}
