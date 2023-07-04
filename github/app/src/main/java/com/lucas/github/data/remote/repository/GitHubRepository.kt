package com.lucas.github.data.remote.repository

import com.lucas.github.domain.model.GitHub
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    suspend fun getListGitHubRepositories(): Flow<GitHub>
}