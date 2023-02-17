package com.gram15inch.domain.model

data class Movie(
    val id: Int,
    val name: String,
    val release: String,
    val thumbnail: String,
    val url: String,
    val rating: Float
)