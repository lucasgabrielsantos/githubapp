package com.lucas.github.presentation.viewmodel

import app.cash.turbine.test
import com.lucas.github.data.remote.commons.MockGitHub
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.usecase.GetListGitHubUseCase
import com.lucas.github.presentation.viewmodel.GitHubEvent.ShowError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
class GitHubViewModelTest {

    private val useCase: GetListGitHubUseCase = mockk()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    private lateinit var viewModel: GitHubViewModel

    @Before
    fun setup() {
        viewModel = GitHubViewModel(useCase, dispatcher)
    }

    @OptIn(ExperimentalTime::class)
    @Test
    fun `getListGitHub should update state with list of GitHub items`() =
        runBlocking {
            // Given
            val expectedList = GitHub(
                totalCount = 4381,
                incompleteResults = false,
                itemsEntity = mutableListOf(MockGitHub.mockItems)
            )
            coEvery { useCase.getListGitHubRepositories() } returns flowOf(expectedList)

            // When
            viewModel.getListGitHub()

            // Then
            viewModel.state.test {
                val currentState = expectItem()
                assertEquals(expectedList, currentState.showListGitHub)
                assertFalse(currentState.isLoading)
                expectComplete()
            }

            coVerify { useCase.getListGitHubRepositories() }
        }

    @OptIn(ExperimentalTime::class)
    @Test
    fun `getListGitHub should emit ShowError event on error`() = runBlocking {
        // Given
        val expectedException = Exception("API Error")
        coEvery { useCase.getListGitHubRepositories() } throws expectedException

        // When
        viewModel.getListGitHub()

        // Then
        viewModel.event.test {
            val event = expectItem()
            assertTrue(event is ShowError && event.throwable == expectedException)
            expectComplete()
        }

        coVerify { useCase.getListGitHubRepositories() }
    }
}
