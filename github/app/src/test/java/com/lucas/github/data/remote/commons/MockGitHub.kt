package com.lucas.github.data.remote.commons

import com.lucas.github.domain.model.ItemsEntity
import com.lucas.github.domain.model.OwnerEntity

object MockGitHub {
    val mockItems = ItemsEntity(
        stargazersCount = 8586,
        fullName = "Geneva Pace",
        description = "utroque",
        owner = OwnerEntity(
            reposUrl = "https://search.yahoo.com/search?p=laoreet",
            followingUrl = "http://www.bing.com/search?q=eam",
            starredUrl = "https://duckduckgo.com/?q=error",
            login = "adipisci",
            followersUrl = "https://search.yahoo.com/search?p=quem",
            url = "https://duckduckgo.com/?q=detraxit",
            subscriptionsUrl = "https://search.yahoo.com/search?p=dolor",
            avatarUrl = "http://www.bing.com/search?q=qualisque",
            id = 7303,
        ),
        forksCount = 2411
    )
}