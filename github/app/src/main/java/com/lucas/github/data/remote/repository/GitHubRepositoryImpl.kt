package com.lucas.github.data.remote.repository

import com.lucas.github.data.remote.datasource.GitHubDataSource
import com.lucas.github.domain.model.GitHub
import kotlinx.coroutines.flow.Flow

class GitHubRepositoryImpl(val datasource: GitHubDataSource) : GitHubRepository {
    override suspend fun getListGitHubRepositories(): Flow<GitHub> = datasource.getListGitHubPopular()

}