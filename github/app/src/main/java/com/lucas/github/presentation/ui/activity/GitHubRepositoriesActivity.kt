package com.lucas.github.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.github.databinding.ActivityListRepositoryBinding
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.ItemsEntity
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

        initViews()
        setupRecyclerView(binding)
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
                        adapter.submitList(it.itemsEntity)
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
                        is ShowGenericError -> {
                            Toast.makeText(
                                this@GitHubRepositoriesActivity,
                                "Erro genérico",
                                Toast.LENGTH_SHORT
                            ).show()
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