package com.lucas.github.presentation.viewmodel


sealed class GitHubEvent {
    data class ShowError(val throwable: Throwable) : GitHubEvent()
    object OnClick : GitHubEvent()
    object DefaultTest : GitHubEvent()
}