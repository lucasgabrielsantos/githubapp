package com.lucas.github.domain.model.repository

import com.lucas.github.domain.model.GitHub
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    fun getListGitHubRepositories(
        query: String,
        page: Int,
        sort: String
    ): Flow<GitHub>
}