package com.lucas.github.data.remote.repository

import com.lucas.github.data.remote.datasource.GitHubDataSource
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow

class GitHubRepositoryImpl(val datasource: GitHubDataSource) : GitHubRepository {

    override fun getListGitHubRepositories(
        query: String,
        sort: String,
        page: String
    ): Flow<GitHub> =
        datasource.getListGitHubPopular(query, sort, page)

}