package com.lucas.github.data.remote.datasource

import com.lucas.github.data.remote.model.GitHubResponse
import com.lucas.github.data.remote.model.Items
import com.lucas.github.data.remote.service.GitHubApi
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.ItemsEntity
import com.lucas.github.domain.model.OwnerEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitHubDataSourceImpl(private val api: GitHubApi) : GitHubDataSource {

    override fun getListGitHubPopular(): Flow<GitHub> =
        flow {
            emit(api.searchRepositories().toDomain())
        }

    private fun GitHubResponse.toDomain() = GitHub(
        totalCount = totalCount,
        incompleteResults = incompleteResults,
        itemsEntity = toDomainList(items)
    )

    private fun toDomainList(items: List<Items>): MutableList<ItemsEntity> {
        val itemsEntities = mutableListOf<ItemsEntity>()
        items.forEach {
            itemsEntities.add(
                ItemsEntity(
                    stargazersCount = it.stargazersCount,
                    fullName = it.fullName,
                    description = it.description,
                    owner = OwnerEntity(
                        gistsUrl = it.owner.gistsUrl,
                        reposUrl = it.owner.reposUrl,
                        followingUrl = it.owner.followingUrl,
                        starredUrl = it.owner.starredUrl,
                        login = it.owner.login,
                        type = it.owner.type,
                        followersUrl = it.owner.followersUrl,
                        url = it.owner.url,
                        subscriptionsUrl = it.owner.subscriptionsUrl,
                        receivedEventsUrl = it.owner.receivedEventsUrl,
                        avatarUrl = it.owner.avatarUrl,
                        eventsUrl = it.owner.eventsUrl,
                        htmlUrl = it.owner.htmlUrl,
                        siteAdmin = it.owner.siteAdmin,
                        id = it.owner.id,
                        gravatarId = it.owner.gravatarId,
                        nodeId = it.owner.nodeId,
                        organizationsUrl = it.owner.organizationsUrl
                    ),
                    forksCount = it.forksCount,
                )
            )
        }
        return itemsEntities
    }
}
