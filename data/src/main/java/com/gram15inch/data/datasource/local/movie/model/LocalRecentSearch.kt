package com.gram15inch.data.datasource.local.movie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class LocalRecentSearch(
    @PrimaryKey(autoGenerate = true) val rid: Int=0,
    val title:String="",
)
