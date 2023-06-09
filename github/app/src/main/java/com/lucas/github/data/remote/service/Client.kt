package com.lucas.github.data.remote.service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private val gson: Gson by lazy { GsonBuilder().setLenient().create() }
    private fun okHttp(): OkHttpClient.Builder {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return httpClient

    }

    private fun retrofit(url: String): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp().build())
        .build()

    fun getService(url: String): GitHubApi = retrofit(url = url).create(GitHubApi::class.java)


//    inline fun <reified T> service(url: String): T = retrofit(url).create(
//        T::class.java
//    )
}