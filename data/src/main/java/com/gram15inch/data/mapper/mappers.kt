package com.gram15inch.data.mapper

import com.gram15inch.data.datasource.local.movie.model.LocalRecentSearch
import com.gram15inch.data.datasource.remote.movie.model.RemoteMovie
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.model.RecentSearch

fun toMovie(remoteMovie: RemoteMovie): Movie {
    return Movie(
        remoteMovie.title.replace("<[^>]*>".toRegex(), ""),
        remoteMovie.pubDate,
        remoteMovie.image,
        remoteMovie.link,
        remoteMovie.userRating.toFloat()
    )
}

fun toRecentSearch(local: LocalRecentSearch): RecentSearch {
    return RecentSearch(local.rid, local.title)
}
