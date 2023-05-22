package com.lucas.github.data.remote.datasource

import com.lucas.github.data.remote.model.GitHubResponse
import com.lucas.github.data.remote.model.ItemsResponse
import com.lucas.github.data.remote.service.GitHubApi
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.ItemsEntity
import com.lucas.github.domain.model.OwnerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitHubDataSourceImpl(private val api: GitHubApi) : GitHubDataSource {

    override suspend fun getListGitHubPopular(): Flow<GitHub> =
        flow {
            emit(api.searchRepositories().toDomain())
        }

    private fun GitHubResponse.toDomain() = GitHub(
        totalCount = totalCount,
        incompleteResults = incompleteResults,
        itemsEntity = toDomainList(items)
    )

    private fun toDomainList(items: List<ItemsResponse>): MutableList<ItemsEntity> {
        val itemsEntities = mutableListOf<ItemsEntity>()
        items.forEach {
            itemsEntities.add(
                ItemsEntity(
                    stargazersCount = it.stargazersCount,
                    fullName = it.fullName,
                    description = it.description,
                    owner = OwnerEntity(
                        reposUrl = it.ownerResponse.reposUrl,
                        followingUrl = it.ownerResponse.followingUrl,
                        starredUrl = it.ownerResponse.starredUrl,
                        login = it.ownerResponse.login,
                        followersUrl = it.ownerResponse.followersUrl,
                        url = it.ownerResponse.url,
                        subscriptionsUrl = it.ownerResponse.subscriptionsUrl,
                        avatarUrl = it.ownerResponse.avatarUrl,
                        id = it.ownerResponse.id,
                    ),
                    forksCount = it.forksCount,
                )
            )
        }
        return itemsEntities
    }
}
