package com.lucas.github.data.remote.service

import com.lucas.github.data.remote.model.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): GitHubResponse
}