package com.lucas.github.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.usecase.GetListGitHubUseCase
import com.lucas.github.presentation.viewmodel.GitHubEvent.ShowError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GitHubViewModel(
    private val useCase: GetListGitHubUseCase,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val initialState: GitHubState by lazy { GitHubState().initialState(initialState = true) }

    private val _uiState: MutableStateFlow<GitHubState> = MutableStateFlow(initialState)
    val state = _uiState.asStateFlow()

    private val _event: MutableSharedFlow<GitHubEvent> = MutableSharedFlow()
    val event = _event.asSharedFlow()

    fun getListGitHub() {
        viewModelScope.launch {
            useCase()
                .onStart { emitStateLoading(true) }
                .catch { emitShowError(it) }
                .onCompletion { emitStateLoading(false) }
                .flowOn(dispatcher)
                .collect { response ->
                    emitStateSuccess(response)
                }
        }
    }

    private fun emitStateSuccess(gitHub: GitHub) {
        _uiState.update { currentState ->
            currentState.copy(showListGitHub = gitHub)
        }
    }

    private fun emitShowError(throwable: Throwable) = viewModelScope.launch {
        _event.emit(ShowError(throwable = throwable))
    }

    private fun emitStateLoading(isLoading: Boolean) = _uiState.update {
        it.copy(isLoading = isLoading)
    }

    private fun onClickRepository() {
        // event.collect()  }
    }
}