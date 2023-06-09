package com.lucas.github.data.remote.repository

import app.cash.turbine.test
import com.lucas.github.data.remote.commons.MockGitHub
import com.lucas.github.data.remote.datasource.GitHubDataSource
import com.lucas.github.domain.model.GitHub
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.jvm.Throws
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class GitHubRepositoryTest {

    private val gitHubDataSource: GitHubDataSource = mockk()

    private val gitHubRepository: GitHubRepository = GitHubRepositoryImpl(
        gitHubDataSource
    )

    @Test
    fun `getListGitHubPopular should emit GitHub object on success`() =
        runBlocking {
            // Given
            val expectedGitHub = GitHub(
                totalCount = 8061,
                incompleteResults = false,
                itemsEntity = mutableListOf(MockGitHub.mockItems)
            )

            coEvery { gitHubDataSource.getListGitHubPopular() } returns flowOf(expectedGitHub)

            // When
            val result = gitHubRepository.getListGitHubRepositories()

            // Then
            result.test {
                assertEquals(expectedGitHub, expectItem())
                expectComplete()
            }
        }
}