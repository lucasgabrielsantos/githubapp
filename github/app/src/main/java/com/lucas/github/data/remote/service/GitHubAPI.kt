package com.lucas.github.data.remote.service

import com.lucas.github.data.remote.model.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val QUERY = "q"
const val SORT = "sort"
private const val LANGUAGE_QUERY = "language:Java"
const val STARS = "stars"
const val PAGE = "page"
const val INITIAL_PAGE = 1
interface GitHubApi {
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query(QUERY, encoded = true) query: String = LANGUAGE_QUERY,
        @Query(SORT) sort: String = STARS,
        @Query(PAGE) page: Int = INITIAL_PAGE
    ): GitHubResponse

    // @GET("repos/{owner}/{repository}/pulls")
    //    fun getPullRequests(@Path("owner") owner: String, @Path("repository") repository: String):
}