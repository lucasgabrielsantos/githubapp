package com.lucas.github.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.github.domain.usecase.GetListGitHubUseCase
import com.lucas.github.presentation.viewmodel.GitHubEvent
import com.lucas.github.presentation.viewmodel.GitHubState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val FIRST_PAGE_INDEX = "1"
private const val LANGUAGE_QUERY = "language=java"
private const val SORT_ORDER = "start"

class GitHubViewModel(
    private val useCase: GetListGitHubUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    init {
        getListGitHub()
    }

    private val initialState: GitHubState by lazy { GitHubState().initialState(initialState = true) }

    private val _uiState: MutableStateFlow<GitHubState> = MutableStateFlow(initialState)
    val state = _uiState.asStateFlow()

    private val _event: MutableSharedFlow<GitHubEvent> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    fun getListGitHub() {
        viewModelScope.launch {
            useCase.getListGitHubRepositories(LANGUAGE_QUERY, SORT_ORDER, FIRST_PAGE_INDEX)
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { _uiState.update { it.copy() } }.flowOn(dispatcher)
                .onCompletion { _uiState.update { it.copy(isLoading = false) } }
                .collect { response ->
                    _uiState.update { it.showListGitHub(response) }
                }
        }
    }

    private fun onClickRepository() {
       // event.collect()  }
    }
}