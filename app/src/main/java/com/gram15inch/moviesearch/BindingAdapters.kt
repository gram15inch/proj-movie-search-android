package com.gram15inch.moviesearch.com.gram15inch.moviesearch

import android.widget.AdapterView.OnItemClickListener
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gram15inch.domain.model.Movie
import com.gram15inch.moviesearch.com.gram15inch.moviesearch.adapter.MovieAdapter

object BindingAdapters {

    @BindingAdapter("items","onMovieClickListener")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items : List<Movie>, clickListener:(Movie)->Unit){
        if(recyclerView.adapter == null) {
            val adapter = MovieAdapter(clickListener)
            recyclerView.adapter = adapter
        }

        val adapter = recyclerView.adapter as MovieAdapter

        adapter.submitList(items)
    }
}