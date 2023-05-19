package com.lucas.github.domain.usecase

import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow

private const val LANGUAGE_QUERY = "language:Java"
private const val SORT_ORDER = "stars"
private const val FIRST_PAGE_INDEX = 1
////https://api.github.com/search/repositories?q=language:Java&sort=stars&

class GetListGitHubUseCase(private val repository: GitHubRepository) {

    fun getListGitHubRepositories(): Flow<GitHub> {
        return repository.getListGitHubRepositories(LANGUAGE_QUERY, SORT_ORDER, FIRST_PAGE_INDEX)
    }
}
