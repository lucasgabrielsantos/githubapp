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


    override fun getListGitHubPopular(
        query: String,
        page: Int,
        order: String
    ): Flow<GitHub> = flow {
        emit(api.searchRepositories(query, page, order).toDomain())
    }


    private fun GitHubResponse.toDomain() = GitHub(
        totalCount = totalCount,
        incompleteResults = incompleteResults,
        itemsEntity = toDomainList(items),
        page = page
    )

    private fun toDomainList(items: List<Items>): MutableList<ItemsEntity> {
        val itemsEntities = mutableListOf<ItemsEntity>()
        items.forEach {
            itemsEntities.add(
                ItemsEntity(
                    stargazersCount = it.stargazersCount,
                    pushedAt = it.pushedAt,
                    language = it.language,
                    subscriptionUrl = it.subscriptionUrl,
                    branchesUrl = it.branchesUrl,
                    issueCommentUrl = it.issueCommentUrl,
                    labelsUrl = it.labelsUrl,
                    score = it.score,
                    subscribersUrl = it.subscribersUrl,
                    releasesUrl = it.releasesUrl,
                    svnUrl = it.svnUrl,
                    id = it.id,
                    masterBranch = it.masterBranch,
                    forks = it.forks,
                    archiveUrl = it.archiveUrl,
                    gitRefsUrl = it.gitRefsUrl,
                    forksUrl = it.forksUrl,
                    visibility = it.visibility,
                    statusesUrl = it.statusesUrl,
                    sshUrl = it.sshUrl,
                    fullName = it.fullName,
                    size = it.size,
                    languagesUrl = it.languagesUrl,
                    htmlUrl = it.htmlUrl,
                    collaboratorsUrl = it.collaboratorsUrl,
                    cloneUrl = it.cloneUrl,
                    name = it.name,
                    pullsUrl = it.pullsUrl,
                    defaultBranch = it.defaultBranch,
                    hooksUrl = it.hooksUrl,
                    treesUrl = it.treesUrl,
                    tagsUrl = it.tagsUrl,
                    private = it.private,
                    contributorsUrl = it.contributorsUrl,
                    hasDownloads = it.hasDownloads,
                    openIssuesCount = it.openIssuesCount,
                    notificationsUrl = it.notificationsUrl,
                    description = it.description,
                    createdAt = it.createdAt,
                    watchers = it.watchers,
                    deploymentsUrl = it.deploymentsUrl,
                    keysUrl = it.keysUrl,
                    hasProjects = it.hasProjects,
                    archived = it.archived,
                    hasWiki = it.hasWiki,
                    updatedAt = it.updatedAt,
                    commentsUrl = it.commentsUrl,
                    stargazersUrl = it.stargazersUrl,
                    disabled = it.disabled,
                    gitUrl = it.gitUrl,
                    hasPages = it.hasPages,
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
                    compareUrl = it.compareUrl,
                    gitCommitsUrl = it.gitCommitsUrl,
                    blobsUrl = it.blobsUrl,
                    gitTagsUrl = it.gitTagsUrl,
                    mergesUrl = it.mergesUrl,
                    downloadsUrl = it.downloadsUrl,
                    hasIssues = it.hasIssues,
                    url = it.url,
                    contentsUrl = it.contentsUrl,
                    mirrorUrl = it.mirrorUrl,
                    milestonesUrl = it.milestonesUrl,
                    teamsUrl = it.teamsUrl,
                    fork = it.fork,
                    issuesUrl = it.issuesUrl,
                    eventsUrl = it.eventsUrl,
                    issueEventsUrl = it.issueEventsUrl,
                    assigneesUrl = it.assigneesUrl,
                    openIssues = it.openIssues,
                    watchersCount = it.watchersCount,
                    nodeId = it.nodeId,
                    homepage = it.homepage,
                    forksCount = it.forksCount,
                    commitsUrl = it.commitsUrl,
                )
            )
        }
        return itemsEntities
    }
}
