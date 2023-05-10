package com.lucas.github.di

import android.app.Application
import com.lucas.github.di.GitHubModule.Api.apiModule
import com.lucas.github.di.GitHubModule.Data.dataModule
import com.lucas.github.di.GitHubModule.Domain.domainModule
import com.lucas.github.di.GitHubModule.Presentation.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

object KoinInitializer {

    private val modules = listOf(apiModule, dataModule, domainModule, uiModule)

    @JvmStatic
    fun initialize(application: Application) {
        startKoin {
            androidContext(application)
            modules(modules)
        }
    }
}