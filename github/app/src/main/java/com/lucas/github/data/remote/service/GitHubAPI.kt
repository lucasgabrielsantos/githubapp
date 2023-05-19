package com.lucas.github.data.remote.service

import com.lucas.github.data.remote.model.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): GitHubResponse

    // @GET("repos/{owner}/{repository}/pulls")
    //    fun getPullRequests(@Path("owner") owner: String, @Path("repository") repository: String):
}

//Exemplo de chamada na API:
//https://api.github.com/search/repositories?q=language:Java&sort=stars&
//page=1
//Paginação na tela de lista, com endless scroll / scroll infinito (incrementando o
//parâmetro page).
//Cada repositório deve exibir Nome do repositório, Descrição do Repositório,
//Nome / Foto do autor, Número de Stars, Número de Forks
//Ao tocar em um item, deve levar a lista de Pull Requests do repositório