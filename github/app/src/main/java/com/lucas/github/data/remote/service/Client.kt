package com.lucas.github.data.remote.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
        companion object {
            private const val BASE_URL = "https://api.github.com/"
        }

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getService(): GitHubApi {
            return retrofit.create(GitHubApi::class.java)
        }
    }