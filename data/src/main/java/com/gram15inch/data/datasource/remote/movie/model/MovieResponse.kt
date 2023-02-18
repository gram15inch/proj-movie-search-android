package com.gram15inch.data.datasource.remote.movie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val display: Int,
    @Json(name = "items")
    val items: List<RemoteMovie>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)