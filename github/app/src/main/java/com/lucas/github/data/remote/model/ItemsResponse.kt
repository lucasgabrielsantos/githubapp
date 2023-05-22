package com.lucas.github.data.remote.model

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("stargazers_count") val stargazersCount: Int = 0,
    @SerializedName("full_name") val fullName: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("owner") val ownerResponse: OwnerResponse,
    @SerializedName("forks_count") val forksCount: Int = 0
)