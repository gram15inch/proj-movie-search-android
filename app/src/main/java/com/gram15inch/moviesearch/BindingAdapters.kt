package com.gram15inch.moviesearch.com.gram15inch.moviesearch

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gram15inch.domain.model.Movie
import com.gram15inch.domain.model.RecentSearch
import com.gram15inch.moviesearch.com.gram15inch.moviesearch.adapter.MovieAdapter
import com.gram15inch.moviesearch.com.gram15inch.moviesearch.adapter.RecentSearchAdapter

object BindingAdapters {

    @BindingAdapter("movieItems","onMovieClickListener","onLastPageListener")
    @JvmStatic
    fun setMovieItems(recyclerView: RecyclerView, items : List<Movie>, clickListener:(Movie)->Unit, lastPageListener:(Int)->Unit){
        if(recyclerView.adapter == null) {
            val adapter = MovieAdapter(clickListener,lastPageListener)
            recyclerView.adapter = adapter
        }

        val adapter = recyclerView.adapter as MovieAdapter

        adapter.submitList(items)
    }

    @BindingAdapter("recentSearchItems","onRecentSearchClickListener")
    @JvmStatic
    fun setRecentSearchItems(recyclerView: RecyclerView, items : List<RecentSearch>, clickListener:(RecentSearch)->Unit){
        if(recyclerView.adapter == null) {
            val adapter = RecentSearchAdapter(clickListener)
            recyclerView.adapter = adapter
        }

        val adapter = recyclerView.adapter as RecentSearchAdapter

        adapter.submitList(items)
    }
}