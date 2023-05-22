package com.lucas.github.data.remote.model

import com.google.gson.annotations.SerializedName

data class OwnerResponse(
    @SerializedName("repos_url")val reposUrl: String = "",
    @SerializedName("following_url")val followingUrl: String = "",
    @SerializedName("starred_url")val starredUrl: String = "",
    @SerializedName("followers_url")val followersUrl: String = "",
    @SerializedName("url")val url: String = "",
    @SerializedName("login") val login: String = "",
    @SerializedName("subscriptions_url")val subscriptionsUrl: String = "",
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("id") val id: Int = 0,
)