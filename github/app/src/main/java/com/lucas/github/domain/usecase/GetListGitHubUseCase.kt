package com.lucas.github.domain.usecase

import com.lucas.github.domain.model.GitHub
import com.lucas.github.data.remote.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow


class GetListGitHubUseCase(private val repository: GitHubRepository) {

     suspend operator fun invoke(): Flow<GitHub> = repository.getListGitHubRepositories()

}
