package com.lucas.github.data.remote.model

import com.google.gson.annotations.SerializedName

data class GitHubResponse(
    @SerializedName("totalCount") val totalCount: Int,
    @SerializedName("incompleteResults") val incompleteResults: Boolean,
    @SerializedName("items") val items: List<ItemsResponse>
    )
