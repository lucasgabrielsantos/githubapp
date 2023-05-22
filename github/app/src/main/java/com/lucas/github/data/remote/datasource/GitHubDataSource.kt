package com.lucas.github.data.remote.datasource

import com.lucas.github.domain.model.GitHub
import kotlinx.coroutines.flow.Flow

interface GitHubDataSource {
    suspend fun getListGitHubPopular(): Flow<GitHub>
}