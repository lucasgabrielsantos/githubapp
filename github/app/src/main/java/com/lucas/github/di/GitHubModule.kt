package com.lucas.github.di

import com.lucas.github.data.remote.datasource.GitHubDataSource
import com.lucas.github.data.remote.datasource.GitHubDataSourceImpl
import com.lucas.github.data.remote.repository.GitHubRepositoryImpl
import com.lucas.github.data.remote.service.Client
import com.lucas.github.data.remote.service.Client.getService
import com.lucas.github.data.remote.service.GitHubApi
import com.lucas.github.domain.model.repository.GitHubRepository
import com.lucas.github.domain.usecase.GetListGitHubUseCase
import com.lucas.github.presentation.viewmodel.GitHubViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val BASE_URL = "https://www.breakingbadapi.com/api/"

object GitHubModule {

    object Api {
        val apiModule = module {
            single<GitHubApi> { getService(BASE_URL) }
        }
    }

    object Data {
        val dataModule = module {
            factory<GitHubDataSource> {
                GitHubDataSourceImpl(api = get())
            }
            factory<GitHubRepository> {
                GitHubRepositoryImpl(datasource = get())
            }
        }
    }

    object Domain {
        val domainModule = module {
            factory {
                GetListGitHubUseCase(
                    repository = get()
                )
            }
        }
    }

    object Presentation {
        val uiModule = module {
            viewModel {
                GitHubViewModel(
                    useCase = get(), dispatcher = get()
                )
            }
        }
    }
}
