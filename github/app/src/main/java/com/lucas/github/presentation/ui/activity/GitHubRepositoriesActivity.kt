package com.lucas.github.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.github.databinding.ActivityListRepositoryBinding
import com.lucas.github.domain.model.ItemsEntity
import com.lucas.github.domain.model.OwnerEntity
import com.lucas.github.presentation.ui.adapter.GitHubAdapter
import com.lucas.github.presentation.viewmodel.GitHubEvent.*
import com.lucas.github.presentation.viewmodel.GitHubViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class GitHubRepositoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListRepositoryBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GitHubAdapter

    private val viewModel: GitHubViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView(binding)
        initViews()
        viewModel.getListGitHub()
    }

    private fun setupRecyclerView(binding: ActivityListRepositoryBinding) {
        adapter = GitHubAdapter()
        recyclerView = binding.rvRepositories
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)
    }

    private fun onPullClicked() {
        val intent = Intent(this, PullRequestsActivity::class.java)
        startActivity(intent)
    }

    private fun initViews() {
        handleStates()
        handleEffects()
    }

    private fun handleStates() {
        viewModel.viewModelScope.launch {
            with(binding) {
                viewModel.state.collect { state ->
                    pbLoading.isVisible = state.isLoading
                    state.showListGitHub?.let {
                        adapter.submitList(listOf(
                            ItemsEntity(
                                stargazersCount = 0,
                                pushedAt = "",
                                language = "",
                                subscriptionUrl = "",
                                branchesUrl = "",
                                issueCommentUrl = "",
                                labelsUrl = "",
                                score = 0,
                                subscribersUrl = "",
                                releasesUrl = "",
                                svnUrl = "",
                                id = 0,
                                masterBranch = "",
                                forks = 0,
                                archiveUrl = "",
                                gitRefsUrl = "",
                                forksUrl = "",
                                visibility = "",
                                statusesUrl = "",
                                sshUrl = "",
                                fullName = "",
                                size = 0,
                                languagesUrl = "",
                                htmlUrl = "",
                                collaboratorsUrl = "",
                                cloneUrl = "",
                                name = "",
                                pullsUrl = "",
                                defaultBranch = "",
                                hooksUrl = "",
                                treesUrl = "",
                                tagsUrl = "",
                                private = false,
                                contributorsUrl = "",
                                hasDownloads = false,
                                openIssuesCount = 0,
                                notificationsUrl = "",
                                description = "",
                                createdAt = "",
                                watchers = 0,
                                deploymentsUrl = "",
                                keysUrl = "",
                                hasProjects = false,
                                archived = false,
                                hasWiki = false,
                                updatedAt = "",
                                commentsUrl = "",
                                stargazersUrl = "",
                                disabled = false,
                                gitUrl = "",
                                hasPages = false,
                                owner = OwnerEntity(
                                    gistsUrl = "",
                                    reposUrl = "",
                                    followingUrl = "",
                                    starredUrl = "",
                                    login = "",
                                    type = "",
                                    followersUrl = "",
                                    url = "",
                                    subscriptionsUrl = "",
                                    receivedEventsUrl = "",
                                    avatarUrl = "",
                                    eventsUrl = "",
                                    htmlUrl = "",
                                    siteAdmin = false,
                                    id = 0,
                                    gravatarId = "",
                                    nodeId = "",
                                    organizationsUrl = ""
                                ),
                                commitsUrl = "",
                                compareUrl = "",
                                gitCommitsUrl = "",
                                blobsUrl = "",
                                gitTagsUrl = "",
                                mergesUrl = "",
                                downloadsUrl = "",
                                hasIssues = false,
                                url = "",
                                contentsUrl = "",
                                mirrorUrl = "",
                                milestonesUrl = "",
                                teamsUrl = "",
                                fork = false,
                                issuesUrl = "",
                                eventsUrl = "",
                                issueEventsUrl = "",
                                assigneesUrl = "",
                                openIssues = 0,
                                watchersCount = 0,
                                nodeId = "",
                                homepage = "",
                                forksCount = 0
                            )
                        ))
                    }
                }
            }
        }
    }

    private fun handleEffects() {
        viewModel.viewModelScope.launch {
            with(binding) {
                viewModel.event.collect { event ->
                    when (event) {
                        is ShowError -> {
                            pbLoading.isVisible = false
                            llError.root.isVisible = true
                        }

                        is OnClick -> {
                            onPullClicked()
                        }

                        else -> {}
                    }
                }

            }
        }
    }
}