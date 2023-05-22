package com.lucas.github.data.remote.repository

import app.cash.turbine.test
import com.lucas.github.data.remote.commons.MockGitHub
import com.lucas.github.data.remote.datasource.GitHubDataSource
import com.lucas.github.domain.model.GitHub
import com.lucas.github.domain.model.repository.GitHubRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
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
            val query = "language:Java"
            val order = "stars"
            val expectedGitHub = GitHub(
                totalCount = 8061,
                incompleteResults = false,
                itemsEntity = mutableListOf(MockGitHub.mockItems)
            )

            every { gitHubDataSource.getListGitHubPopular(query, order) } returns flowOf(
                expectedGitHub
            )

            // When
            val result = gitHubRepository.getListGitHubRepositories(query, order)

            // Then
            result.test {
                assertEquals(expectedGitHub, expectItem())
                expectComplete()
            }
        }

    @Test
    fun `fetchNowPlayingMovies should return movie entity list`() = runBlocking {
        @Test
        fun `getListGitHubPopular should emit error on failure`() =
            runBlocking {
                // Given
                val query = "language:Java"
                val order = "stars"
                val throwable = Throwable()
                val expectedException = Exception(throwable)

                every {
                    gitHubDataSource.getListGitHubPopular(
                        query,
                        order
                    )
                } throws expectedException

                // When
                val result = gitHubRepository.getListGitHubRepositories(query, order)

                // Then
                result.test {
                    expectError()
                    expectComplete()
                }
            }
    }
}