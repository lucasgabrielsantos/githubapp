package com.lucas.github.data.remote.datasource

import com.lucas.github.domain.model.GitHub
import kotlinx.coroutines.flow.Flow

interface GitHubDataSource {

    fun getListGitHubPopular(query: String, sort: String, order: String): Flow<GitHub>
}