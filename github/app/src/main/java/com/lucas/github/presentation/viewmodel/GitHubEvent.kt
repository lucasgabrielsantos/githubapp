package com.lucas.github.presentation.viewmodel


sealed class GitHubEvent {
    object ShowGenericError : GitHubEvent()
    object OnClick : GitHubEvent()
}