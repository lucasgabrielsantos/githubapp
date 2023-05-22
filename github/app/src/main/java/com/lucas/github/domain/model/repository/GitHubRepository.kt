package com.lucas.github.domain.model.repository

import com.lucas.github.domain.model.GitHub
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    suspend fun getListGitHubRepositories(): Flow<GitHub>
}